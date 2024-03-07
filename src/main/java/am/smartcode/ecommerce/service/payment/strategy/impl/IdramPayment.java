package am.smartcode.ecommerce.service.payment.strategy.impl;

import am.smartcode.ecommerce.service.payment.strategy.PaymentStrategy;
import am.smartcode.ecommerce.util.constants.PaymentType;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class IdramPayment implements PaymentStrategy {

    private final PaymentType paymentType = PaymentType.IDRAM;

    @Override
    public String pay(BigDecimal amount) {
        return new StringBuilder()
                .append("Payment type is:")
                .append(paymentType)
                .append(" and total amount is ")
                .append(amount.toString()).toString();
    }

    @Override
    public PaymentType getPaymentType() {
        return paymentType;
    }
}