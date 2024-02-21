package am.smartcode.ecommerce.controller.product;

import am.smartcode.ecommerce.model.dto.product.CreateProductDto;
import am.smartcode.ecommerce.model.dto.product.ProductDto;
import am.smartcode.ecommerce.model.dto.product.ProductFilter;
import am.smartcode.ecommerce.service.product.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


//@Controller
//@ResponseBody
@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @PreAuthorize("hasRole('USER')")
    @PostMapping("/filter")
    public ResponseEntity<List<ProductDto>> getAll(@RequestBody ProductFilter productFilter) {
//        return new ResponseEntity<>(productService.getAll(),HttpStatus.OK);
        return ResponseEntity.ok(productService.getAll(productFilter));
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getById(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.getById(id));
    }


}
