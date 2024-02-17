package am.smartcode.ecommerce.model.dto.card;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.CreditCardNumber;

@Getter
@Setter
public class CardDto {

    @NotBlank
    private String name;

    @NotBlank
    @CreditCardNumber
    private String cardNumber;

    @NotBlank
    private String expDate;

    @NotNull
    private Integer userId;
}
