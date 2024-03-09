package am.smartcode.ecommerce.model.dto.basket;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BasketCreatDto {

    @NotNull
    @Positive
    private Integer productId;

    @NotNull
    @Positive
    private Integer quantity;
}
