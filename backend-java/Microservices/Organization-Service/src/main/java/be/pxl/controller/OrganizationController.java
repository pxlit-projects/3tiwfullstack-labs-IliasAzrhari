package be.pxl.controller;

import be.pxl.services.IOrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/organization")
@RequiredArgsConstructor
public class OrganizationController {

    private final IOrganizationService organizationService;

    @GetMapping
    public ResponseEntity getOrganizations() {
        return new ResponseEntity(organizationService.getAllOrganizations(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(Long id) {
        return new ResponseEntity(organizationService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/{id}/with-departments")
    public ResponseEntity findByIdWithDepartments(Long id) {
        return new ResponseEntity(organizationService.findByIdWithDepartments(id), HttpStatus.OK);
    }

    @GetMapping("/{id}/with-departments-and-employees")
    public ResponseEntity findByIdWithDepartmentsAndEmployees(Long id) {
        return new ResponseEntity(organizationService.findByIdWithDepartmentsAndEmployees(id), HttpStatus.OK);
    }

    @GetMapping("/{id}/with-employees")
    public ResponseEntity findByIdWithEmployees(Long id) {
        return new ResponseEntity(organizationService.findByIdWithEmployees(id), HttpStatus.OK);
    }

}
