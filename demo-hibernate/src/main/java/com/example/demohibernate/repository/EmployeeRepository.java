package com.example.demohibernate.repository;

import com.example.demohibernate.model.EmployeesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeesEntity, Integer> {
}
