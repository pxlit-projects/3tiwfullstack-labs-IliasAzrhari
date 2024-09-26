package be.pxl.services;

import be.pxl.domain.Organization;
import be.pxl.domain.dto.OrganizationResponse;
import be.pxl.repository.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrganizationService implements IOrganizationService {

    private final OrganizationRepository organizationRepository;

    @Override
    public List<OrganizationResponse> getAllOrganizations() {

      return organizationRepository.findAll()
                .stream()
                .map(organization -> mapToOrganizationResponse(organization))
                .collect(Collectors.toList());
    }



    @Override
    public OrganizationResponse findById(Long id) {
       return organizationRepository.findById(id)
               .map(organization -> mapToOrganizationResponse(organization))
               .orElse(null);
    }

    @Override
    public List<OrganizationResponse> findByIdWithDepartments(Long id) {
       return organizationRepository.findAll()
                .stream()
                .filter(organization -> organization.getId().equals(id) && !organization.getDepartments().isEmpty())
               .map(organization -> mapToOrganizationResponse(organization))
               .collect(Collectors.toList());
    }

    @Override
    public List<OrganizationResponse> findByIdWithDepartmentsAndEmployees(Long id) {
        return organizationRepository.findAll()
                .stream()
                .filter(organization -> organization.getId().equals(id) && !organization.getDepartments().isEmpty() && !organization.getDepartments().get(0).getEmployees().isEmpty())
                .map(organization -> mapToOrganizationResponse(organization))
                .collect(Collectors.toList());

    }

    @Override
    public List<OrganizationResponse> findByIdWithEmployees(Long id) {
        return organizationRepository.findAll()
                .stream()
                .filter(organization -> organization.getId().equals(id) && !organization.getEmployees().isEmpty())
                .map(organization -> mapToOrganizationResponse(organization))
                .collect(Collectors.toList());
    }

    private OrganizationResponse mapToOrganizationResponse(Organization organization) {
        return OrganizationResponse.builder()
                .name(organization.getName())
                .address(organization.getAddress())
                .departments(organization.getDepartments())
                .employees(organization.getEmployees())
                .build();
    }
}
