package home.nkavtur.kmsdemoapplication.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@Accessors(chain = true)
@Table(name = "order")
public class OrderEntity {

    @Id
    @GeneratedValue
    @Column(name = "order_uuid")
    private UUID uuid;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "user_uuid")
    private UserEntity user;

    public OrderEntity setUser(UserEntity user) {
        this.user = user;
        user.getOrders().add(this);
        return this;
    }

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "order_product",
            joinColumns = @JoinColumn(name = "order_uuid"),
            inverseJoinColumns = @JoinColumn(name = "product_uuid")
    )
    private Set<ProductEntity> products = new HashSet<>();


    public OrderEntity addProduct(ProductEntity product) {
        products.add(product);
        product.getOrders().add(this);
        return this;
    }

    public OrderEntity removeProduct(ProductEntity product) {
        products.remove(product);
        product.removeOrder(this);
        return this;
    }

    @Override
    public String toString() {
        return "OrderEntity{" +
                "uuid=" + uuid +
                '}';
    }
}
