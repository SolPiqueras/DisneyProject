package ar.solPiqueras.disney.data.repositories;

import ar.solPiqueras.disney.data.entities.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<MovieEntity, Long> {

}
