package am.smartcode.ecommerce.repository.order;

import am.smartcode.ecommerce.model.entity.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItemEntity, Integer> {
}