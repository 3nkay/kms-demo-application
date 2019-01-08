package home.nkavtur.kmsdemoapplication.repository;

import home.nkavtur.kmsdemoapplication.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<ProductEntity, UUID> {

}
