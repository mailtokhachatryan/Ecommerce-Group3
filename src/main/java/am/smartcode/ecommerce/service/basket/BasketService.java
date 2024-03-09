package am.smartcode.ecommerce.service.basket;

import am.smartcode.ecommerce.model.dto.basket.BasketCreatDto;
import am.smartcode.ecommerce.model.dto.basket.BasketDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BasketService {

    List<BasketDto> getBasket();

    BasketDto addProduct(BasketCreatDto basketCreatDto);

    void deleteProduct(Integer productId);
}
