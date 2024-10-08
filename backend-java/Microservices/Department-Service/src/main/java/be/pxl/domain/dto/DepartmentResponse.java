package be.pxl.domain.dto;

import be.pxl.domain.Employee;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentResponse {

    private Long organizationId;

    private String name;

    private List<Employee> employees;

    private String position;
}
