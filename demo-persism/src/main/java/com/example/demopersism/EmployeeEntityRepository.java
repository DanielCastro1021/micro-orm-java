package com.example.demopersism;

import com.example.demopersism.model.EmployeesEntity;
import lombok.extern.java.Log;
import net.sf.persism.SQL;
import net.sf.persism.Session;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.util.List;

import static net.sf.persism.Parameters.params;

@Log
@Component
public class EmployeeEntityRepository {
    private final Session session;

    public EmployeeEntityRepository(Connection connection) {
        this.session = new Session(connection);
    }

    public List<EmployeesEntity> findAll() {
        return session.query(EmployeesEntity.class, SQL.sql("SELECT * FROM employees"));
    }

    public EmployeesEntity findById(int id) {
        return session.fetch(EmployeesEntity.class, SQL.sql("SELECT * FROM employees WHERE emp_no = ?"), params(id));
    }

    public EmployeesEntity save(EmployeesEntity employeesEntity) {
        return session.insert(employeesEntity).dataObject();
    }

    public EmployeesEntity update(EmployeesEntity employeesEntity) {
        //Maybe implement with id
        return session.update(employeesEntity).dataObject();
    }

    public void delete(EmployeesEntity employeesEntity) {
        //Maybe implement with id
        session.delete(employeesEntity);
    }

    public long count() {
        return session.fetch(long.class, SQL.sql("SELECT count(*) FROM employees"));
    }
}
