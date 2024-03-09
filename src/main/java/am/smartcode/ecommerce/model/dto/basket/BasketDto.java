package am.smartcode.ecommerce.model.dto.basket;

import am.smartcode.ecommerce.model.dto.product.BaseProductDto;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class BasketDto {
    private Integer id;

    private BaseProductDto product;

    private Integer quantity;

    private BigDecimal totalPrice;

}
