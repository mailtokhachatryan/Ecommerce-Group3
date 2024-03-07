package am.smartcode.ecommerce.model.dto.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@AllArgsConstructor
public class OrderDto {

    private Integer id;

    private BigDecimal totalPrice;

}
