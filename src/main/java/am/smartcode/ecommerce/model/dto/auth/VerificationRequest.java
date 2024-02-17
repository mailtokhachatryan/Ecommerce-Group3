package am.smartcode.ecommerce.model.dto.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class VerificationRequest {

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String code;
}
