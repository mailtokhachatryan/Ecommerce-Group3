package am.smartcode.ecommerce.service.product.impl;

import am.smartcode.ecommerce.exception.EntityNotFoundException;
import am.smartcode.ecommerce.mapper.ProductMapper;
import am.smartcode.ecommerce.model.dto.product.CreateProductDto;
import am.smartcode.ecommerce.model.dto.product.ProductDto;
import am.smartcode.ecommerce.model.dto.product.ProductFilter;
import am.smartcode.ecommerce.model.entity.CategoryEntity;
import am.smartcode.ecommerce.model.entity.ProductEntity;
import am.smartcode.ecommerce.repository.CategoryRepository;
import am.smartcode.ecommerce.repository.ProductRepository;
import am.smartcode.ecommerce.service.product.ProductService;
import am.smartcode.ecommerce.spec.ProductSpec;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final CategoryRepository categoryRepository;
    private final ProductSpec productSpec;


    @Override
    @Transactional
    public ProductDto create(CreateProductDto createProductDto) {
        ProductEntity entity = productMapper.toEntity(createProductDto);
        CategoryEntity categoryEntity = categoryRepository.
                findById(createProductDto.getCategoryId()).
                orElseThrow(() -> new EntityNotFoundException(""));
        entity.setCategory(categoryEntity);
        productRepository.save(entity);
        return productMapper.toDto(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductDto> getAll(ProductFilter productFilter) {
        return productRepository.findAll(productSpec.filter(productFilter))
                .stream()
                .map(productMapper::toDto)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public ProductDto getById(Integer id) {
        ProductEntity productEntity = productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("Product with id: %d not found.", id)));
        return productMapper.toDto(productEntity);
    }
}
