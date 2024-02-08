package am.smartcode.ecommerce.model.dto.product;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateProductDto extends BaseProductDto {

    private Integer categoryId;

}
