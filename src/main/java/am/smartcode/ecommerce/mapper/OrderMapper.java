package am.smartcode.ecommerce.mapper;

import am.smartcode.ecommerce.model.dto.order.OrderDto;
import am.smartcode.ecommerce.model.dto.product.ProductDetails;
import am.smartcode.ecommerce.model.entity.OrderEntity;
import am.smartcode.ecommerce.model.entity.ProductEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface OrderMapper {


    ProductDetails toProductDetails(ProductEntity productEntity);

    OrderDto toDto(OrderEntity order);

}
