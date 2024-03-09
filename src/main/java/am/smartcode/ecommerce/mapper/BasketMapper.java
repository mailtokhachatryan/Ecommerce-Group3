package am.smartcode.ecommerce.mapper;

import am.smartcode.ecommerce.model.dto.basket.BasketCreatDto;
import am.smartcode.ecommerce.model.dto.basket.BasketDto;
import am.smartcode.ecommerce.model.entity.BasketEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface BasketMapper {
    BasketEntity toEntity(BasketCreatDto basketCreatDto);

    BasketEntity toEntity(BasketDto basketDto);

    BasketDto toDto(BasketEntity basketEntity);

}
