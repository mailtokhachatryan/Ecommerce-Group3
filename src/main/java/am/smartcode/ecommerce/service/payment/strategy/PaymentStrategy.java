package am.smartcode.ecommerce.service.payment.strategy;

import am.smartcode.ecommerce.service.payment.PaymentService;
import am.smartcode.ecommerce.util.constants.PaymentType;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

public interface PaymentStrategy {

    String pay(BigDecimal amount);

    PaymentType getPaymentType();

    @Autowired
    default void register(@NotNull PaymentService paymentService) {
        paymentService.register(getPaymentType(), this);
    }

}