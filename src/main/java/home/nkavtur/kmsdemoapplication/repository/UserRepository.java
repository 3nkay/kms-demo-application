package home.nkavtur.kmsdemoapplication.repository;

import home.nkavtur.kmsdemoapplication.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {

}
