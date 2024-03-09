package am.smartcode.ecommerce.model.dto.basket;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BasketDto {
    @NotNull
    private Integer id;
}
