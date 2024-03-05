package am.smartcode.ecommerce.controller;

import am.smartcode.ecommerce.model.dto.product.CreateProductDto;
import am.smartcode.ecommerce.model.dto.product.ProductDto;
import am.smartcode.ecommerce.model.dto.product.ProductFilter;
import am.smartcode.ecommerce.service.product.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductDto> create(@RequestBody @Valid CreateProductDto createProductDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.create(createProductDto));
    }

    @PostMapping("/filter")
    public ResponseEntity<List<ProductDto>> getAll(@RequestBody ProductFilter productFilter) {
//        return new ResponseEntity<>(productService.getAll(),HttpStatus.OK);
        return ResponseEntity.ok(productService.getAll(productFilter));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getById(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.getById(id));
    }
}
