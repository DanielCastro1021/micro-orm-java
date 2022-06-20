package com.example.demoormlite;

import com.example.demoormlite.model.Employee;
import com.example.demoormlite.repository.EmployeeRepository;
import lombok.extern.java.Log;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, ExecutionTimeTestExecutionListener.class})
class DemoOrmliteApplicationTests {

    @Autowired
    private EmployeeRepository repository;

    @Test
    void save() throws SQLException {
        Employee e = new Employee("Daniel", "Blonde");
        repository.save(e);
        assertEquals(e, repository.findById(e.getId()));
    }
}
