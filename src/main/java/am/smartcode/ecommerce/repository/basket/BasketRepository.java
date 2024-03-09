package am.smartcode.ecommerce.repository.basket;

import am.smartcode.ecommerce.model.entity.BasketEntity;
import am.smartcode.ecommerce.model.entity.ProductEntity;
import am.smartcode.ecommerce.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BasketRepository extends JpaRepository<BasketEntity, Integer> {
    List<BasketEntity> findAllByUserId(Integer userId);

    void deleteAllByUser(UserEntity user);

    void deleteByProduct(ProductEntity productEntity);

    void deleteByIdAndUserId(Integer productId,Integer userId);
}