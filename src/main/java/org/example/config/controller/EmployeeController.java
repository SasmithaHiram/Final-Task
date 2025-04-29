package org.example.config.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.Employee;
import org.example.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
@CrossOrigin
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody Employee employee) {
        boolean isCreated = employeeService.create(employee);

        if (isCreated) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Employee Created Successfully");
        } else {
            return null;
        }
    }

    @GetMapping("SearchById/{id}")
    public ResponseEntity<Employee> searchById(@PathVariable Long id) {
        Employee searchById = employeeService.searchById(id);

        if (searchById!=null) {
            return ResponseEntity.ok(searchById);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody Employee employee) {
        boolean isUpdated = employeeService.update(employee);

        if (isUpdated) {
            return ResponseEntity.status(HttpStatus.OK).body("Employee Updated Successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed To Update Employee");
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(Long id) {
        boolean isDeleted = employeeService.delete(id);

        if (isDeleted) {
            return ResponseEntity.status(HttpStatus.OK).body("Employee Deleted Successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed To Delete Employee");
        }
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<Employee>> getAll() {
        List<Employee> all = employeeService.getAll();

        if (all==null || all.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.ok(all);
        }

    }

}
