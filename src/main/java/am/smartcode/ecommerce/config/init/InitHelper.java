package am.smartcode.ecommerce.config.init;

import am.smartcode.ecommerce.model.entity.RoleEntity;
import am.smartcode.ecommerce.model.entity.UserEntity;
import am.smartcode.ecommerce.repository.UserRepository;
import am.smartcode.ecommerce.repository.role.RoleRepository;
import am.smartcode.ecommerce.util.constants.RoleEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class InitHelper {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void createRoleAndAdmin() {
        if (!roleRepository.existsByName(RoleEnum.ADMIN)) {
            RoleEntity admin = new RoleEntity();
            admin.setName(RoleEnum.ADMIN);
            roleRepository.save(admin);
        }

        if (!roleRepository.existsByName(RoleEnum.USER)) {
            RoleEntity user = new RoleEntity();
            user.setName(RoleEnum.USER);

            roleRepository.save(user);
        }

        if (!userRepository.existsByEmail("admin@gmail.com")) {
            UserEntity userEntity = UserEntity.builder()
                    .name("Admin")
                    .lastname("Admin")
                    .birthday(LocalDate.now())
                    .role(roleRepository.findByName(RoleEnum.ADMIN))
                    .email("admin@gmail.com")
                    .password(passwordEncoder.encode("adminPassword"))
                    .isVerified(true)
                    .code("123456").build();

            userRepository.save(userEntity);
        }
    }

}
