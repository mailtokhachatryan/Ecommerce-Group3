package am.smartcode.ecommerce.service.order;

import am.smartcode.ecommerce.model.dto.order.OrderCreateDto;
import am.smartcode.ecommerce.model.dto.order.OrderDto;

public interface OrderService {
    OrderDto create(OrderCreateDto createDto);
}
