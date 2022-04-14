package ar.solPiqueras.disney.data.repositories;

import ar.solPiqueras.disney.data.entities.OrganizationEntity;
import ar.solPiqueras.disney.domain.organizations.Organization;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface OrganizationRepository extends CrudRepository<OrganizationEntity, Long> {
    List<OrganizationEntity> findAll();
    Optional<OrganizationEntity> findById(long idOrganization);
    OrganizationEntity save(Organization organization);
}