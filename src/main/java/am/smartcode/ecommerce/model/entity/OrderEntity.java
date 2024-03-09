package am.smartcode.ecommerce.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "orders")
public class OrderEntity extends BaseEntity {

    @Column(nullable = false)
    private BigDecimal totalPrice;

    @ManyToOne(optional = false)
    private UserEntity user;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order")
    private List<OrderItemEntity> orderItems;

}
