package am.smartcode.ecommerce.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "basket")
@Setter
@Getter
public class BasketEntity extends BaseEntity {

    @ManyToOne(optional = false)
    private UserEntity user;

    @ManyToOne(optional = false)
    private ProductEntity product;

    @Column(nullable = false)
    private Integer quantity;

}
