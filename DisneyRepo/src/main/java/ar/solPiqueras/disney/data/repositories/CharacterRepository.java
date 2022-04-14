package ar.solPiqueras.disney.data.repositories;

import ar.solPiqueras.disney.data.entities.CharacterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepository extends JpaRepository<CharacterEntity, Long> {

}
