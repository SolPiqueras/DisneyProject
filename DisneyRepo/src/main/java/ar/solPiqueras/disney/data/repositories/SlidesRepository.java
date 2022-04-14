package ar.solPiqueras.disney.data.repositories;

import ar.solPiqueras.disney.data.entities.SlidesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SlidesRepository extends JpaRepository<SlidesEntity, Long> {
    SlidesEntity findTopByOrderBySlideOrderDesc();
}
