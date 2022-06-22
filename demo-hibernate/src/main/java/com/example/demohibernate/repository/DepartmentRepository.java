package com.example.demohibernate.repository;

import com.example.demohibernate.model.DepartmentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<DepartmentsEntity, String> {
}
