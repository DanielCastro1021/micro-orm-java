package com.example.demohibernate.repository;

import com.example.demohibernate.model.SalariesEntity;
import com.example.demohibernate.model.SalariesEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalariesRepository extends JpaRepository<SalariesEntity, SalariesEntityPK> {
}
