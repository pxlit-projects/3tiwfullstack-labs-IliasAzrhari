package be.pxl.controller;

import be.pxl.domain.dto.EmployeeRequest;
import be.pxl.services.IEmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final IEmployeeService employeeservice;


    @GetMapping
    public ResponseEntity getEmployees() {
        return new ResponseEntity(employeeservice.getAllEmployees(), HttpStatus.OK);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addEmployee(@RequestBody EmployeeRequest employeeRequest) {
        employeeservice.addEmployee(employeeRequest);
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        return new ResponseEntity(employeeservice.findById(id), HttpStatus.OK);
    }

    @GetMapping("/department/{departmentId}")
    public ResponseEntity findByDepartment(@PathVariable Long departmentId) {
        return new ResponseEntity(employeeservice.findByDepartment(departmentId), HttpStatus.OK);
    }

    @GetMapping("/organization/{organizationId}")
    public ResponseEntity findByOrganization(@PathVariable Long organizationId) {
        return new ResponseEntity(employeeservice.findByOrganization(organizationId), HttpStatus.OK);
    }
}
