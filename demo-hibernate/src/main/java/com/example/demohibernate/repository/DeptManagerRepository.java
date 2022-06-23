package com.example.demohibernate.repository;

import com.example.demohibernate.model.DeptManagerEntity;
import com.example.demohibernate.model.DeptManagerEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeptManagerRepository extends JpaRepository<DeptManagerEntity, DeptManagerEntityPK> {
}
