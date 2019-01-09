package home.nkavtur.kmsdemoapplication;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

import static com.google.common.base.MoreObjects.toStringHelper;

@Getter
@Setter
@Entity
@Accessors(chain = true)
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "user_uuid")
    private UUID uuid;

    private String name;

    private String creditCard;

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(name, user.name) &&
                Objects.equals(creditCard, user.creditCard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, creditCard);
    }

    @Override
    public String toString() {
        return toStringHelper(this)
                .add("name", this.name)
                .add("creditCard", this.creditCard)
                .toString();
    }

}
