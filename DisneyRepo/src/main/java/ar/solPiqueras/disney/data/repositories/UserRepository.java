package ar.solPiqueras.disney.data.repositories;

import ar.solPiqueras.disney.data.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    List<UserEntity> findByDeleted(boolean isDeleted);

    Optional<UserEntity> findByEmail(String email);

    boolean existsByEmail(String email);

}
