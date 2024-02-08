package am.smartcode.ecommerce.model.entity;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;

@Entity
@Setter
@Getter
@Table(name = "products")
public class ProductEntity extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private BigDecimal price;

    @ManyToOne(optional = false)
    private CategoryEntity category;

}
