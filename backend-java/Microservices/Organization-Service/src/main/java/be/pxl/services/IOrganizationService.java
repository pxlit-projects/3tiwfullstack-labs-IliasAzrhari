package be.pxl.services;

import be.pxl.domain.dto.OrganizationResponse;

import java.util.List;

public interface IOrganizationService {

    List<OrganizationResponse> getAllOrganizations();

    OrganizationResponse findById(Long id);

    List<OrganizationResponse> findByIdWithDepartments(Long id);

    List<OrganizationResponse> findByIdWithDepartmentsAndEmployees(Long id);

    List<OrganizationResponse> findByIdWithEmployees(Long id);
}
