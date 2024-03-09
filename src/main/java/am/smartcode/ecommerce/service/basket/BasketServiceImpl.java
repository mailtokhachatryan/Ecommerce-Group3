package am.smartcode.ecommerce.service.basket;


import am.smartcode.ecommerce.exception.EntityNotFoundException;
import am.smartcode.ecommerce.mapper.BasketMapper;
import am.smartcode.ecommerce.model.dto.basket.BasketCreatDto;
import am.smartcode.ecommerce.model.dto.basket.BasketDto;
import am.smartcode.ecommerce.model.entity.BasketEntity;
import am.smartcode.ecommerce.model.entity.UserEntity;
import am.smartcode.ecommerce.repository.ProductRepository;
import am.smartcode.ecommerce.repository.UserRepository;
import am.smartcode.ecommerce.repository.basket.BasketRepository;
import am.smartcode.ecommerce.util.CurrentUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BasketServiceImpl implements BasketService {
    private final BasketRepository basketRepository;
    private final BasketMapper basketMapper;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    @Override
    @Transactional(readOnly = true)
    public List<BasketDto> getBasket() {
        List<BasketEntity> allByUserId = basketRepository.findAllByUserId(CurrentUser.getId());
        List<BasketDto> list = allByUserId.stream().map(basketMapper::toDto).
                toList();
        list.forEach(basketDto ->
                basketDto.setTotalPrice(basketDto.getProduct().getPrice().multiply(new BigDecimal(basketDto.getQuantity())))
        );
        return list;
    }


    @Override
    @Transactional
    public BasketDto addProduct(BasketCreatDto basketCreatDto) {
        BasketEntity basketEntity = new BasketEntity();
        UserEntity userEntity = userRepository.findById(CurrentUser.getId()).get();
        basketEntity.setUser(userEntity);
        basketEntity.setProduct(
                productRepository.findById(basketCreatDto.getProductId()).orElseThrow(
                        () -> new EntityNotFoundException("Product by id " + basketCreatDto.getProductId() + " does not exists"))
        );
        basketEntity.setQuantity(basketCreatDto.getQuantity());
        basketRepository.save(basketEntity);
        BasketDto dto = basketMapper.toDto(basketEntity);
        dto.setTotalPrice(dto.getProduct().getPrice().multiply(new BigDecimal(dto.getQuantity())));

        return dto;
    }

    @Override
    @Transactional
    public void deleteProduct(Integer productId) {
        basketRepository.deleteByIdAndUserId(productId, CurrentUser.getId());
    }


}
