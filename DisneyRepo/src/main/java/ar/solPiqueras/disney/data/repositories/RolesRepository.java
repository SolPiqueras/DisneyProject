package ar.solPiqueras.disney.data.repositories;

import ar.solPiqueras.disney.data.entities.RolesEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends CrudRepository<RolesEntity, Long> {

}
