package am.smartcode.ecommerce.mapper;

import am.smartcode.ecommerce.model.dto.category.CategoryDto;
import am.smartcode.ecommerce.model.dto.category.CreateCategoryDto;
import am.smartcode.ecommerce.model.dto.category.UpdateCategoryDto;
import am.smartcode.ecommerce.model.entity.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryEntity toEntity(CreateCategoryDto createCategoryDto);



    CategoryDto toDto(CategoryEntity categoryEntity);

    void update(@MappingTarget CategoryEntity categoryEntity, UpdateCategoryDto updateCategoryDto);

}
