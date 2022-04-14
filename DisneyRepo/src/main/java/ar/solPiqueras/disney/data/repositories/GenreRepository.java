package ar.solPiqueras.disney.data.repositories;

import ar.solPiqueras.disney.data.entities.GenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<GenreEntity, Long> {

}
