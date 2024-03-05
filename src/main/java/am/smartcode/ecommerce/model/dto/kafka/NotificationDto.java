package am.smartcode.ecommerce.model.dto.kafka;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class NotificationDto {

    @NotBlank
    private String title;

    @NotBlank
    private String content;

    private String description;

    @NotNull
    private LocalDateTime notificationDate;

    @Email
    @NotBlank
    private String email;

    @Positive
    private Integer userId;
}
