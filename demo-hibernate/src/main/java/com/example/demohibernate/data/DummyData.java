package com.example.demohibernate.data;

import com.example.demohibernate.repository.EmployeeRepository;
import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Log
@Configuration
public class DummyData implements CommandLineRunner {
    private final EmployeeRepository repository;

    public DummyData(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
      //  Employee e1 = this.repository.save(new Employee("Daniel", "Blonde"));
      //  Employee e2 = this.repository.save(new Employee("Josep", "Blonde"));
      //  Employee e3 = this.repository.save(new Employee("Daniel", "Blonde"));
      //  log.info(e1.toString());
      //  log.info(e2.toString());
      //  log.info(e3.toString());
    }
}
