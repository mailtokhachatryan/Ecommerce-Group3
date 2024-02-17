package am.smartcode.ecommerce.repository.role;

import am.smartcode.ecommerce.model.entity.RoleEntity;
import am.smartcode.ecommerce.util.constants.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {
    boolean existsByName(RoleEnum roleEnum);

    RoleEntity findByName(RoleEnum roleEnum);
}