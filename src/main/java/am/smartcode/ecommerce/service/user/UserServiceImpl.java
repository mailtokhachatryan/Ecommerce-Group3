package am.smartcode.ecommerce.service.user;

import am.smartcode.ecommerce.exception.EntityNotFoundException;
import am.smartcode.ecommerce.exception.ValidationException;
import am.smartcode.ecommerce.mapper.UserMapper;
import am.smartcode.ecommerce.model.dto.user.UpdateUserDto;
import am.smartcode.ecommerce.model.dto.user.UserDetailsImpl;
import am.smartcode.ecommerce.model.dto.user.UserDto;
import am.smartcode.ecommerce.model.entity.UserEntity;
import am.smartcode.ecommerce.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    @Transactional
    public UserDto update(UpdateUserDto updateUserDto, int id) {
        UserEntity userById = userRepository.findById(id).orElseThrow();
        userMapper.update(userById, updateUserDto);
        userRepository.save(userById);
        return userMapper.toDto(userById);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDto getById(int id) {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (id != userDetails.getId())
            throw new ValidationException("Incorrect access");
        return userMapper.toDto(userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Entity Not Found")));
    }

    @Override
    @Transactional
    public List<UserDto> getAll() {
        return userRepository.findAll().stream().map(userMapper::toDto).toList();
    }

    @Override
    @Transactional
    public void delete(int id) {
        userRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDto getByEmail(String email) {
        return userMapper.toDto(userRepository.findByEmail(email));
    }


}
