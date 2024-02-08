package am.smartcode.ecommerce.repository;

import am.smartcode.ecommerce.model.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {
}