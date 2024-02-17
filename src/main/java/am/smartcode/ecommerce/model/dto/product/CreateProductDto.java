package am.smartcode.ecommerce.model.dto.product;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateProductDto extends BaseProductDto {

    @NotNull
    private Integer categoryId;

}
