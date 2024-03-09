package am.smartcode.ecommerce.model.dto.basket;

import am.smartcode.ecommerce.model.entity.ProductEntity;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BasketCreatDto {

    @NotNull
    private ProductEntity product;
    @NotNull
    private Integer quantity;
}
