package home.nkavtur.kmsdemoapplication.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Entity
@Accessors(chain = true)
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue
    @Column(name = "user_uuid")
    private UUID uuid;

    private String name;

    private String creditCard;

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL
    )
    @BatchSize(size = 30)
    private List<OrderEntity> orders = new ArrayList<>();

    public UserEntity addOrder(OrderEntity order) {
        orders.add(order);
        order.setUser(this);
        return this;
    }

    public UserEntity removeOrder(OrderEntity order) {
        order.setUser(null);
        orders.remove(order);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserEntity user = (UserEntity) o;
        return Objects.equals(name, user.name) &&
                Objects.equals(creditCard, user.creditCard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, creditCard);
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "uuid=" + uuid +
                ", name='" + name + '\'' +
                ", creditCard='" + creditCard + '\'' +
                '}';
    }
}
