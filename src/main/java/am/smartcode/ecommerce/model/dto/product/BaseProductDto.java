package am.smartcode.ecommerce.model.dto.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class BaseProductDto {

    @NotBlank
    private String name;

    @NotNull
    private BigDecimal price;
}
