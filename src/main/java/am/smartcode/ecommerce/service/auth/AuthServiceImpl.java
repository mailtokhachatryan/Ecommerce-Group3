package am.smartcode.ecommerce.service.auth;


import am.smartcode.ecommerce.config.security.jwt.JwtService;
import am.smartcode.ecommerce.event.publisher.CustomEventPublisher;
import am.smartcode.ecommerce.exception.EntityNotFoundException;
import am.smartcode.ecommerce.exception.InvalidPasswordException;
import am.smartcode.ecommerce.exception.UserAlreadyExistsException;
import am.smartcode.ecommerce.exception.VerificationException;
import am.smartcode.ecommerce.mapper.UserMapper;
import am.smartcode.ecommerce.model.dto.auth.AuthenticationDto;
import am.smartcode.ecommerce.model.dto.auth.LoginRequest;
import am.smartcode.ecommerce.model.dto.auth.RegisterRequestDto;
import am.smartcode.ecommerce.model.dto.auth.VerificationRequest;
import am.smartcode.ecommerce.model.dto.user.ChangePasswordDto;
import am.smartcode.ecommerce.model.dto.user.UserDto;
import am.smartcode.ecommerce.model.entity.UserEntity;
import am.smartcode.ecommerce.repository.UserRepository;
import am.smartcode.ecommerce.repository.role.RoleRepository;
import am.smartcode.ecommerce.service.action.ActionService;
import am.smartcode.ecommerce.util.RandomGenerator;
import am.smartcode.ecommerce.util.constants.Massage;
import am.smartcode.ecommerce.util.constants.RoleEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
@RequiredArgsConstructor
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final AuthenticationProvider authenticationProvider;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final RoleRepository roleRepository;
    private final CustomEventPublisher eventPublisher;
    private final ActionService actionService;

    @Override
    @Transactional
    public AuthenticationDto login(LoginRequest loginRequest) {

        UserEntity user = userRepository.findByEmail(loginRequest.getEmail());
        if (!user.isVerified())
            throw new VerificationException(Massage.VERIFICATION_ERROR);

        authenticationProvider.authenticate(new UsernamePasswordAuthenticationToken(
                loginRequest.getEmail(),
                loginRequest.getPassword()
        ));

        String token = jwtService.generateToken(user.getEmail(), user.getId(),user.getRole().getName().getName());

        return new AuthenticationDto(token);
    }

    @Override
    @Transactional
    public UserDto register(RegisterRequestDto requestDto) {
        UserEntity byEmail = userRepository.findByEmail(requestDto.getEmail());
        if (byEmail != null)
            throw new UserAlreadyExistsException("User with this email already exists");

        UserEntity user = userMapper.toEntity(requestDto);

        String code = RandomGenerator.generateNumericString(6);
        user.setVerified(false);
        user.setCode(code);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(roleRepository.findByName(RoleEnum.USER));

        eventPublisher.publishRegistrationEvent(user);
        userRepository.save(user);

        actionService.create(user.getId(), "CREATE", "USER");

        return userMapper.toDto(user);
    }

    @Override
    @Transactional
    public void verify(VerificationRequest verificationRequest) {
        UserEntity byEmail = userRepository.findByEmail(verificationRequest.getEmail());
        if (!verificationRequest.getCode().equals(byEmail.getCode())) {
            throw new VerificationException("Code is incorrect");
        }

        byEmail.setVerified(true);
        userRepository.save(byEmail);
    }

    @Override
    @Transactional(readOnly = true)
    public UserEntity getByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    @Transactional
    public void changePassword(ChangePasswordDto changePasswordDto) {
        Integer id = changePasswordDto.getId();
        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Product with id: %d not found.", id)));
        validate(changePasswordDto);
        userEntity.setPassword(changePasswordDto.getNewPassword());
        userRepository.save(userEntity);
    }

    private void validate(ChangePasswordDto changePasswordDto) {
        if (changePasswordDto.getOldPassword().equals(changePasswordDto.getNewPassword()) ||
                !changePasswordDto.getNewPassword().equals(changePasswordDto.getNewPassword2()))
            throw new InvalidPasswordException("Invalid password");
    }
}

