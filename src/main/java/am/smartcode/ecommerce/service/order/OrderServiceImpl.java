package am.smartcode.ecommerce.service.order;

import am.smartcode.ecommerce.model.dto.order.OrderCreateDto;
import am.smartcode.ecommerce.model.dto.order.OrderDto;
import am.smartcode.ecommerce.model.entity.BasketEntity;
import am.smartcode.ecommerce.model.entity.OrderEntity;
import am.smartcode.ecommerce.model.entity.OrderItemEntity;
import am.smartcode.ecommerce.model.entity.UserEntity;
import am.smartcode.ecommerce.repository.UserRepository;
import am.smartcode.ecommerce.repository.basket.BasketRepository;
import am.smartcode.ecommerce.repository.order.OrderItemRepository;
import am.smartcode.ecommerce.repository.order.OrderRepository;
import am.smartcode.ecommerce.service.payment.PaymentService;
import am.smartcode.ecommerce.util.CurrentUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final PaymentService paymentService;
    private final BasketRepository basketRepository;
    private final UserRepository userRepository;

    @Override
    public OrderDto create(OrderCreateDto createDto) {
        List<BasketEntity> allBasketEntities = basketRepository.findAllByUserId(CurrentUser.getId());
        BigDecimal totalPrice = new BigDecimal(0);
        for (BasketEntity basketEntity : allBasketEntities) {
            totalPrice = totalPrice.add(
                    basketEntity.getProduct().getPrice().multiply(new BigDecimal(basketEntity.getQuantity()))
            );
        }

        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setTotalPrice(totalPrice);
        UserEntity user = userRepository.findById(CurrentUser.getId()).get();
        orderEntity.setUser(user);
        orderRepository.save(orderEntity);

        for (BasketEntity basketEntity : allBasketEntities) {
            OrderItemEntity orderItemEntity = new OrderItemEntity();
            BigDecimal multiply = basketEntity.getProduct().getPrice().multiply(new BigDecimal(basketEntity.getQuantity()));
            orderItemEntity.setTotalPrice(multiply);
            orderItemEntity.setQuantity(basketEntity.getQuantity());
            orderItemEntity.setOrder(orderEntity);
            orderItemEntity.setProduct(basketEntity.getProduct());
            orderItemRepository.save(orderItemEntity);
        }


        paymentService.pay(createDto.getPaymentType(), totalPrice);

        basketRepository.deleteAllByUser(user);
        return new OrderDto(orderEntity.getId(), orderEntity.getTotalPrice());
    }


}
