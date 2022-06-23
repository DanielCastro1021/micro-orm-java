package com.example.demopersism;

import com.example.demopersism.model.EmployeesEntity;
import lombok.extern.java.Log;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Log
@SpringBootTest
@ExtendWith(SpringExtension.class)
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, ExecutionTimeTestExecutionListener.class})
class EmployeeEntityRepositoryTests {

    @Autowired
    private EmployeeEntityRepository employeeRepository;


    @Test
    void injectedComponentsAreNotNull() {
        assertNotNull(employeeRepository);
    }


    @Nested
    class ReadOperations {
        @Test
        void findAllEmployees() throws SQLException {
            assertEquals(300070, employeeRepository.count());
        }

        @Test
        void findByIdEmployee() throws SQLException {
            EmployeesEntity e1 = new EmployeesEntity();
            e1.setEmpNo(10001);
            e1.setFirstName("Georgi");
            e1.setLastName("Facello");
            e1.setGender(EmployeesEntity.GenderEnum.M);
            e1.setHireDate(Date.valueOf(LocalDate.of(1986, 6, 26)));
            e1.setBirthDate(Date.valueOf(LocalDate.of(1953, 9, 2)));
            assertEquals(e1, employeeRepository.findById(e1.getEmpNo()));
        }
    }

    @Nested
    class WriteOperations {
        @Test
        void saveEmployee() throws SQLException {
            EmployeesEntity employeesEntity = new EmployeesEntity();
            employeesEntity.setEmpNo(60);
            employeesEntity.setFirstName("Daniel");
            employeesEntity.setLastName("Castro");
            employeesEntity.setGender(EmployeesEntity.GenderEnum.M);
            employeesEntity.setHireDate(Date.valueOf(LocalDate.now()));
            employeesEntity.setBirthDate(Date.valueOf(LocalDate.of(1998, 11, 30)));
            employeeRepository.save(employeesEntity);
            assertEquals(60, employeesEntity.getEmpNo());
            employeeRepository.delete(employeesEntity);
        }

        @Test
        void updateEmployee() throws SQLException {
            EmployeesEntity e = employeeRepository.findById(40);
            EmployeesEntity.GenderEnum genderEnum;
            if (e.getGender() == EmployeesEntity.GenderEnum.M) {
                genderEnum = EmployeesEntity.GenderEnum.F;
            } else {
                genderEnum = EmployeesEntity.GenderEnum.M;
            }
            e.setGender(genderEnum);
            employeeRepository.update(e);
            assertEquals(e, employeeRepository.findById(40));
        }


        @Test
        void deleteEmployee() throws SQLException {
            long count = employeeRepository.count();
            EmployeesEntity employeesEntity = new EmployeesEntity();
            employeesEntity.setEmpNo(60);
            employeesEntity.setFirstName("Daniel");
            employeesEntity.setLastName("Castro");
            employeesEntity.setGender(EmployeesEntity.GenderEnum.M);
            employeesEntity.setHireDate(Date.valueOf(LocalDate.now()));
            employeesEntity.setBirthDate(Date.valueOf(LocalDate.of(1998, 11, 30)));
            employeeRepository.save(employeesEntity);
            assertEquals(count + 1, employeeRepository.count());
            employeeRepository.delete(employeesEntity);
            assertEquals(count, employeeRepository.count());
        }
    }
}
