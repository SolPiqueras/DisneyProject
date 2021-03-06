package ar.solPiqueras.disney.data.gateways;

import ar.solPiqueras.disney.web.exceptions.ResourceNotFoundException;
import ar.solPiqueras.disney.data.entities.OrganizationEntity;
import ar.solPiqueras.disney.data.repositories.OrganizationRepository;
import ar.solPiqueras.disney.domain.organizations.Organization;
import ar.solPiqueras.disney.domain.organizations.OrganizationGateway;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;


import static java.util.stream.Collectors.toList;

@Component
public class DefaultOrganizationGateway implements OrganizationGateway {

    private final OrganizationRepository organizationRepository;

    public DefaultOrganizationGateway(OrganizationRepository organizationRepository) {

        this.organizationRepository = organizationRepository;
    }

    @Override
    public Organization findById(long idOrganization) {
        OrganizationEntity ong = organizationRepository.findById(idOrganization).orElseThrow(() -> new ResourceNotFoundException("Organization not found"));

        return toModel(ong);
    }

    @GetMapping("/public/{id}")
    public Organization showOrganization(@PathVariable long id) {
        OrganizationEntity organization = organizationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Organization not found"));
        return toModel(organization);
    }

    @PutMapping("/public/{id}")
    public Organization update(Organization organization) {
        OrganizationEntity ongEntity = organizationRepository.findById(organization.getIdOrganization()).orElseThrow(() -> new ResourceNotFoundException("Organization not found"));
        return toModel(organizationRepository.save(newUpdate(ongEntity, organization)));
    }

    private OrganizationEntity newUpdate(OrganizationEntity organizationEntity, Organization organization) {
        organizationEntity.setName(organization.getName());
        organizationEntity.setImage(organization.getImage());
        organizationEntity.setAddress(organization.getAddress());
        organizationEntity.setPhone(organization.getPhone());
        organizationEntity.setEmail(organization.getEmail());
        organizationEntity.setAbout_us_text(organization.getAbout_us_text());
        organizationEntity.setWelcome_text(organization.getWelcome_text());
        organizationEntity.setCreatedAt(organization.getCreatedAt());
        organizationEntity.setUpdatedAt(organization.getUpdatedAt());
        organizationEntity.setDeleted(organization.getDeleted());
        return organizationEntity;
    }
    public static Organization toModel(OrganizationEntity organizationEntity){
        return Organization.builder()
                .idOrganization(organizationEntity.getIdOrganization())
                .name(organizationEntity.getName())
                .image(organizationEntity.getImage())
                .address(organizationEntity.getAddress())
                .phone(organizationEntity.getPhone())
                .email(organizationEntity.getEmail())
                .about_us_text(organizationEntity.getAbout_us_text())
                .welcome_text(organizationEntity.getWelcome_text())
                .createdAt(organizationEntity.getCreatedAt())
                .updatedAt(organizationEntity.getUpdatedAt())
                .deleted(organizationEntity.getDeleted())
                .facebookLink(organizationEntity.getFacebookLink())
                .instagramLink(organizationEntity.getInstagramLink())
                .linkedinLink(organizationEntity.getLinkedinLink())
                .slides(organizationEntity.getSlides()
                        .stream()
                        .map(slide -> DefaultSlidesGateway.simpleToDomain(slide))
                        .collect(toList()))
                .build();
    }

    public static OrganizationEntity toEntity(Organization organization) {
        return OrganizationEntity.builder()
                .name(organization.getName())
                .image(organization.getImage())
                .address(organization.getAddress())
                .phone(organization.getPhone())
                .email(organization.getEmail())
                .about_us_text(organization.getAbout_us_text())
                .welcome_text(organization.getWelcome_text())
                .createdAt(organization.getCreatedAt())
                .updatedAt(organization.getUpdatedAt())
                .deleted(organization.getDeleted())
                .facebookLink(organization.getFacebookLink())
                .instagramLink(organization.getInstagramLink())
                .linkedinLink(organization.getLinkedinLink())
                .build();
    }
}
