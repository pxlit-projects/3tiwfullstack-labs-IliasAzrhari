package be.pxl.services;

import be.pxl.domain.Department;
import be.pxl.domain.Employee;
import be.pxl.domain.dto.DepartmentRequest;
import be.pxl.domain.dto.DepartmentResponse;
import be.pxl.domain.dto.EmployeeResponse;
import be.pxl.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepartmentService implements IDepartmentService {

    private final DepartmentRepository departmentRepository;
    @Override
    public List<DepartmentResponse> getAllDepartments() {
        return departmentRepository.findAll()
                .stream()
                .map(this::mapToDepartmentResponse)
                .collect(Collectors.toList());
    }

    @Override
    public DepartmentResponse findById(Long id) {
        return departmentRepository.findById(id)
                .map(this::mapToDepartmentResponse)
                .orElse(null);
    }

    @Override
    public List<DepartmentResponse> findByOrganization(Long organizationId) {
        return departmentRepository.findByOrganizationId(organizationId)
                .stream()
                .map(this::mapToDepartmentResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<DepartmentResponse> findByOrganizationWithEmployees(Long organizationId) {
        return departmentRepository.findByOrganizationIdWithEmployees(organizationId)
                .stream()
                .filter(department -> !department.getEmployees().isEmpty())
                .map(this::mapToDepartmentResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void addDepartment(DepartmentRequest departmentRequest) {
        Department department = Department.builder()
                .name(departmentRequest.getName())
                .organizationId(departmentRequest.getOrganizationId())
                .position(departmentRequest.getPosition())
                .employees(departmentRequest.getEmployees())
                .build();
        departmentRepository.save(department);
    }

    private DepartmentResponse mapToDepartmentResponse(Department department) {
        return DepartmentResponse.builder()
                .name(department.getName())
                .organizationId(department.getOrganizationId())
                .position(department.getPosition())
                .employees(department.getEmployees())
                .build();
    }
}
