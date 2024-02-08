package am.smartcode.ecommerce.service.category;

import am.smartcode.ecommerce.model.dto.category.CategoryDto;
import am.smartcode.ecommerce.model.dto.category.CreateCategoryDto;
import am.smartcode.ecommerce.model.dto.category.UpdateCategoryDto;

import java.util.List;

public interface CategoryService {
    CategoryDto create(CreateCategoryDto createCategoryDto);

    List<CategoryDto> getAll();

    CategoryDto getById(Integer id);
    CategoryDto update(UpdateCategoryDto updateCategoryDto, int id);
    void delete(int id);

}
