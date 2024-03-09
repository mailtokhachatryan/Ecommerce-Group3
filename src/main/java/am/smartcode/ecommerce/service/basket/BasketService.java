package am.smartcode.ecommerce.service.basket;

import am.smartcode.ecommerce.model.dto.basket.BasketCreatDto;
import am.smartcode.ecommerce.model.dto.basket.BasketDto;
import am.smartcode.ecommerce.model.entity.ProductEntity;

public interface BasketService {
    BasketDto addProduct(BasketCreatDto basketCreatDto);
    void deleteProduct(ProductEntity productEntity);

}
