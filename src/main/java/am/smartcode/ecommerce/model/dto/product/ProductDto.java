package am.smartcode.ecommerce.model.dto.product;

import am.smartcode.ecommerce.model.dto.category.CategoryDto;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductDto extends BaseProductDto {

    private Integer id;

    private CategoryDto category;

}
