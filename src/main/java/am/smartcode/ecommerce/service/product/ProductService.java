package am.smartcode.ecommerce.service.product;

import am.smartcode.ecommerce.model.dto.product.CreateProductDto;
import am.smartcode.ecommerce.model.dto.product.ProductDto;
import am.smartcode.ecommerce.model.dto.product.ProductFilter;

import java.util.List;

public interface ProductService {

    ProductDto create(CreateProductDto createProductDto);

    List<ProductDto> getAll(ProductFilter productFilter);

    ProductDto getById(Integer id);
}
