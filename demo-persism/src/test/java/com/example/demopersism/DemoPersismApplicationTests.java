package com.example.demopersism;

import com.example.demopersism.model.Employee;
import lombok.extern.java.Log;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Log
@SpringBootTest
@ExtendWith(SpringExtension.class)
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, ExecutionTimeTestExecutionListener.class})
class DemoPersismApplicationTests {

    @Autowired
    private EmployeeRepository repository;

    @Test
    void saveTest() {
        Employee employee = new Employee("Michael", "Redhead");
        assertEquals(repository.save(employee), employee);
    }

}
