package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.dto.Employee;
import org.example.entity.EmployeeEntity;
import org.example.repository.EmployeeRepository;
import org.example.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    @Override
    public boolean create(Employee employee) {
        if (employee!=null) {
            employeeRepository.save(modelMapper.map(employee, EmployeeEntity.class));
            return true;
        }
        return false;
    }

    @Override
    public Employee searchById(Long id) {
        Employee found = modelMapper.map(employeeRepository.findById(id), Employee.class);

        if (found==null) {
            return null;
        } else {
            return found;
        }
    }

    @Override
    public boolean update(Employee employee) {
        boolean isUpdated = this.create(employee);

        if (isUpdated) {
            return isUpdated;
        }
        return false;
    }

    @Override
    public boolean delete(Long id) {
        if (id!=null) {
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Employee> getAll() {
        List<EmployeeEntity> entities = employeeRepository.findAll();

        ArrayList<Employee> employees = new ArrayList<>();

        entities.forEach(employeeEntity -> {
            Employee map = modelMapper.map(employeeEntity, Employee.class);
            employees.add(map);
        });
        return employees;
    }

}
