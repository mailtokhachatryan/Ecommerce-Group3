package am.smartcode.ecommerce.model.entity;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Setter
@Getter
@Table(name = "categories")
public class CategoryEntity extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String category;

}
