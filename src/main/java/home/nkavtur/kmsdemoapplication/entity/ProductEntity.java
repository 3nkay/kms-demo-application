package home.nkavtur.kmsdemoapplication.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.*;

@Entity
@Getter
@Setter
@Accessors(chain = true)
@Table(name = "product")
public class ProductEntity {

    @Id
    @GeneratedValue
    @Column(name = "product_uuid")
    private UUID uuid;

    private String name;

    @ManyToMany(mappedBy = "products")
    private Set<OrderEntity> orders = new HashSet<>();

    public void addOrder(OrderEntity order) {
        this.orders.add(order);
        order.getProducts().add(this);
    }

    public void removeOrder(OrderEntity order) {
        this.orders.remove(order);
        order.getProducts().remove(this);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProductEntity product = (ProductEntity) o;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "ProductEntity{" +
                "uuid=" + uuid +
                ", name='" + name + '\'' +
                '}';
    }
}
