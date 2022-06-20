package com.example.demohibernate;

import com.example.demohibernate.model.Employee;
import com.example.demohibernate.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;


import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, ExecutionTimeTestExecutionListener.class})
class DemoHibernateApplicationTests {

    @Autowired
    private EmployeeRepository repository;

    @Test
    void injectedComponentsAreNotNull() {
        assertThat(repository).isNotNull();
    }

    @Test
    void whenSaved_thenFindsByName() {
        Employee e = new Employee(
                "Luis",
                "Red");
        repository.save(e);
        assertThat(repository.findEmployeeByName("Luis")).isNotNull();
        repository.delete(e);
    }

    @Test
    void timeQueryFindEmployeeByName() {
        repository.findEmployeeByName("Luis");
    }
}
