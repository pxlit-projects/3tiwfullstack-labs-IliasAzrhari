package be.pxl.services;

import be.pxl.domain.Department;
import be.pxl.domain.dto.DepartmentRequest;
import be.pxl.domain.dto.DepartmentResponse;

import java.util.List;

public interface IDepartmentService {

    List<DepartmentResponse> getAllDepartments();

    DepartmentResponse findById(Long id);

    List<DepartmentResponse> findByOrganization(Long organizationId);

    List<DepartmentResponse> findByOrganizationWithEmployees(Long organizationId);

    void addDepartment(DepartmentRequest departmentRequest);
}
