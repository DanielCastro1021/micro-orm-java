package com.example.demohibernate;

import com.example.demohibernate.repository.DepartmentRepository;
import com.example.demohibernate.repository.EmployeeRepository;
import com.example.demohibernate.repository.SalariesRepository;
import lombok.extern.java.Log;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import static org.assertj.core.api.Assertions.assertThat;

@Log
@SpringBootTest
@ExtendWith(SpringExtension.class)
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, ExecutionTimeTestExecutionListener.class})
class DemoHibernateApplicationTests {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private SalariesRepository salariesRepository;

    @Test
    void injectedComponentsAreNotNull() {
        assertThat(employeeRepository).isNotNull();
        assertThat(departmentRepository).isNotNull();
    }

    @Test
    void findAllEmployees() {
        log.info(String.valueOf((long) employeeRepository.findAll().size()));
    }

    @Test
    void findAllDepartments() {
        log.info(String.valueOf((long) departmentRepository.findAll().size()));
    }

    @Test
    void findAllSalaries() {
        salariesRepository.findAll().forEach(salariesEntity -> log.info(salariesEntity.toString()));
        //log.info(String.valueOf((long) salariesRepository.findAll().size()));
    }
}
