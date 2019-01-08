package home.nkavtur.kmsdemoapplication.repository;

import home.nkavtur.kmsdemoapplication.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<OrderEntity, UUID> {
}
