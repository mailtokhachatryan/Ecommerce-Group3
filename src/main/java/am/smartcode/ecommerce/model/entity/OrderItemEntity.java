package am.smartcode.ecommerce.model.entity;

import am.smartcode.ecommerce.model.dto.product.ProductDetails;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.math.BigDecimal;

@Entity
@Setter
@Getter
@Table(name = "order_items")
public class OrderItemEntity extends BaseEntity {

    @Column(nullable = false)
    private BigDecimal totalPrice;

    @Column(nullable = false)
    private Integer quantity;

    @ManyToOne(optional = false)
    private OrderEntity order;

    @Column(nullable = false)
    @JdbcTypeCode(SqlTypes.JSON)
    private ProductDetails productDetails;

}
