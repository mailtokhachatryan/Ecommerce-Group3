package am.smartcode.ecommerce.model.dto.email;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class SendEmailDto {
    private String to;
    private String subject;
    private String text;
}
