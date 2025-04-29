package org.example.service;

import org.example.dto.Employee;

import java.util.List;

public interface EmployeeService {
    boolean create(Employee employee);
    Employee searchById(Long id);
    boolean update(Employee employee);
    boolean delete(Long id);
    List<Employee> getAll();
}
