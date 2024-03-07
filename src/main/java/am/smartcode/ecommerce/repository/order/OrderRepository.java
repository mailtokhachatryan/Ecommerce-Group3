package am.smartcode.ecommerce.repository.order;

import am.smartcode.ecommerce.model.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {
}