package am.smartcode.ecommerce.model.dto.order;

import am.smartcode.ecommerce.util.constants.PaymentType;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderCreateDto {

    private PaymentType paymentType;

}
