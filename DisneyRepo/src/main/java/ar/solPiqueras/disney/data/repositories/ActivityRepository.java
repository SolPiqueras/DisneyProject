package ar.solPiqueras.disney.data.repositories;

import ar.solPiqueras.disney.data.entities.ActivityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ActivityRepository extends JpaRepository<ActivityEntity, Long> {



}
