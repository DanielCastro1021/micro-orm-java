package com.example.demo.repository;

import com.example.demo.model.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    Employee findEmployeeByName(String name);

    List<Employee> findEmployeeByNameAndEyeColor(String name, String eyeColor);
}
