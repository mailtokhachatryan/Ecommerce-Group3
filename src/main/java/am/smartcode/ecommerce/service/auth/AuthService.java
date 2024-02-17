package am.smartcode.ecommerce.service.auth;

import am.smartcode.ecommerce.model.dto.auth.AuthenticationDto;
import am.smartcode.ecommerce.model.dto.auth.LoginRequest;
import am.smartcode.ecommerce.model.dto.auth.RegisterRequestDto;
import am.smartcode.ecommerce.model.dto.auth.VerificationRequest;
import am.smartcode.ecommerce.model.dto.user.ChangePasswordDto;
import am.smartcode.ecommerce.model.dto.user.UserDto;
import am.smartcode.ecommerce.model.entity.UserEntity;

public interface AuthService {

    AuthenticationDto login(LoginRequest loginRequest);

    UserDto register(RegisterRequestDto requestDto);

    void verify(VerificationRequest verificationRequest);

    UserEntity getByEmail(String email);

    void changePassword(ChangePasswordDto changePasswordDto);
}
