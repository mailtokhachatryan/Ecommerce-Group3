package am.smartcode.ecommerce.controller;


import am.smartcode.ecommerce.model.dto.auth.AuthenticationDto;
import am.smartcode.ecommerce.model.dto.auth.LoginRequest;
import am.smartcode.ecommerce.model.dto.auth.RegisterRequestDto;
import am.smartcode.ecommerce.model.dto.auth.VerificationRequest;
import am.smartcode.ecommerce.model.dto.user.UserDto;
import am.smartcode.ecommerce.service.auth.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthenticationDto> login(@RequestBody @Valid LoginRequest loginRequest) {
        return ResponseEntity.ok(authService.login(loginRequest));
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody @Valid RegisterRequestDto requestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(authService.register(requestDto));
    }

    @PostMapping("/verify")
    public ResponseEntity<Void> verify(@RequestBody @Valid VerificationRequest verificationRequest) {
        authService.verify(verificationRequest);
        return ResponseEntity.ok().build();
    }

}
