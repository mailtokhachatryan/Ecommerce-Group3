package am.smartcode.ecommerce.controller.category;

import am.smartcode.ecommerce.model.dto.category.CategoryDto;
import am.smartcode.ecommerce.model.dto.category.CreateCategoryDto;
import am.smartcode.ecommerce.model.dto.category.UpdateCategoryDto;
import am.smartcode.ecommerce.service.category.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/categories")
@RequiredArgsConstructor
public class AdminCategoryController {

    private final CategoryService categoryService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<CategoryDto> create(@RequestBody CreateCategoryDto createCategoryDto) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.create(createCategoryDto));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        categoryService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<CategoryDto> update(@RequestBody UpdateCategoryDto updateCategoryDto, @PathVariable Integer id) {
        return ResponseEntity.ok(categoryService.update(updateCategoryDto, id));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAll() {
        return ResponseEntity.ok(categoryService.getAll());
    }


}
