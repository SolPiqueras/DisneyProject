package ar.solPiqueras.disney.domain.organizations;





public interface OrganizationGateway {
  Organization findById(long idOrganization);
  Organization update(Organization organization);
}
