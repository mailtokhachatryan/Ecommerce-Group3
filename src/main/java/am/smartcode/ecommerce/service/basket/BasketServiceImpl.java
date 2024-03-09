package am.smartcode.ecommerce.service.basket;


import am.smartcode.ecommerce.mapper.BasketMapper;
import am.smartcode.ecommerce.model.dto.basket.BasketCreatDto;
import am.smartcode.ecommerce.model.dto.basket.BasketDto;
import am.smartcode.ecommerce.model.entity.BasketEntity;
import am.smartcode.ecommerce.model.entity.ProductEntity;
import am.smartcode.ecommerce.model.entity.UserEntity;
import am.smartcode.ecommerce.repository.UserRepository;
import am.smartcode.ecommerce.repository.basket.BasketRepository;
import am.smartcode.ecommerce.util.CurrentUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

//TODO: add functionality
@Service
@RequiredArgsConstructor
public class BasketServiceImpl implements BasketService{
    private final BasketRepository basketRepository;
    private final BasketMapper basketMapper;
    private final UserRepository userRepository;

    @Override
    public BasketDto addProduct(BasketCreatDto basketCreatDto){
        BasketEntity entity = basketMapper.toEntity(basketCreatDto);
        UserEntity userEntity = userRepository.findById(CurrentUser.getId()).get();
        entity.setUser(userEntity);
        basketRepository.save(entity);
        return basketMapper.toDto(entity);
    }

    @Override
    public void deleteProduct(ProductEntity productEntity) {
        basketRepository.deleteByProduct(productEntity);

    }


}
