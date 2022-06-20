package com.example.demopersism;

import com.example.demopersism.model.Employee;
import lombok.extern.java.Log;
import net.sf.persism.Result;
import net.sf.persism.SQL;
import net.sf.persism.Session;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.util.List;

import static net.sf.persism.Parameters.params;

@Log
@Component
public class EmployeeRepository {
    private final Session session;

    public EmployeeRepository(Connection connection) {
        this.session = new Session(connection);
    }

    public List<Employee> findAll() {
        return session.query(Employee.class, SQL.sql("SELECT * FROM employee"));
    }

    public Employee findById(int id) {
        return session.fetch(Employee.class, SQL.sql("SELECT * FROM employee WHERE name = ?"), params(id));
    }

    public Employee save(Employee employee) {
        return session.insert(employee).dataObject();
    }

    public Employee update(Employee employee) {
        //Maybe implement with id
        return session.update(employee).dataObject();
    }

    public void delete(Employee employee) {
        //Maybe implement with id
        session.delete(employee);
    }
}
