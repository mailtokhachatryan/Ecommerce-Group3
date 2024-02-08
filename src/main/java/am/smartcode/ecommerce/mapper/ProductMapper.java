package am.smartcode.ecommerce.mapper;

import am.smartcode.ecommerce.model.dto.product.CreateProductDto;
import am.smartcode.ecommerce.model.dto.product.ProductDto;
import am.smartcode.ecommerce.model.dto.product.UpdateProductDto;
import am.smartcode.ecommerce.model.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductEntity toEntity(CreateProductDto createProductDto);

    ProductDto toDto(ProductEntity product);

    void updateEntity(@MappingTarget ProductEntity product, UpdateProductDto updateProductDto);

}
