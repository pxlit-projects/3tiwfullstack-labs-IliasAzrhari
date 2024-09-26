package be.pxl.services;

import be.pxl.domain.Employee;
import be.pxl.domain.dto.EmployeeRequest;
import be.pxl.domain.dto.EmployeeResponse;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IEmployeeService {

    List<EmployeeResponse> getAllEmployees();

    EmployeeResponse findById(Long id);

    List<EmployeeResponse> findByDepartment(Long departmentId);

    List<EmployeeResponse> findByOrganization(Long organizationId);

    void addEmployee(EmployeeRequest employeeRequest);
}
