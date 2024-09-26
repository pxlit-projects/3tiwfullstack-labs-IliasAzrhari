package be.pxl.repository;

import be.pxl.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    List<Department> findByOrganizationId(Long organizationId);
    List<Department> findByOrganizationIdWithEmployees(Long organizationId);
}
