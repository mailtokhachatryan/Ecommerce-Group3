package am.smartcode.ecommerce.repository;

import am.smartcode.ecommerce.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    UserEntity findByEmail(String email);

    boolean existsByEmail(String mail);
}
