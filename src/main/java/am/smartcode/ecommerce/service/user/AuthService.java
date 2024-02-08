package am.smartcode.ecommerce.service.user;

import am.smartcode.ecommerce.model.dto.user.ChangePasswordDto;
import am.smartcode.ecommerce.model.dto.user.CreateUserDto;
import am.smartcode.ecommerce.model.entity.UserEntity;

public interface AuthService {

    void login(String email, String password);

    void register(CreateUserDto createUserDto);

    void verify(String email, String code);

    UserEntity getByEmail(String email);

    void changePassword(ChangePasswordDto changePasswordDto);
}
