package am.smartcode.ecommerce.model.dto.product;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class BaseProductDto {

    private String name;

    private BigDecimal price;
}
