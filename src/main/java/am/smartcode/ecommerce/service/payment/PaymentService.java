package am.smartcode.ecommerce.service.payment;

import am.smartcode.ecommerce.service.payment.strategy.PaymentStrategy;
import am.smartcode.ecommerce.util.constants.PaymentType;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.Map;

@Service
public class PaymentService {

    private final Map<PaymentType, PaymentStrategy> payments = new EnumMap<>(PaymentType.class);

    public void register(PaymentType paymentType, PaymentStrategy paymentStrategy) {
        payments.put(paymentType, paymentStrategy);
    }

    public String pay(PaymentType paymentType, BigDecimal amount) {
        return payments.get(paymentType).pay(amount);
    }
}