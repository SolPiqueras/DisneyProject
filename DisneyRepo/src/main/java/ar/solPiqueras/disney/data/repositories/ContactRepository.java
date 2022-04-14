package ar.solPiqueras.disney.data.repositories;

import ar.solPiqueras.disney.data.entities.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<ContactEntity, Long> {
}
