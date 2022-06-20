package com.example.demoormlite.repository;

import com.example.demoormlite.model.Employee;
import com.example.demoormlite.model.EmployeeDao;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;

@Component
public class EmployeeRepository extends BaseDaoImpl<Employee, Integer> implements EmployeeDao {

    public EmployeeRepository(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, Employee.class);
        TableUtils.createTableIfNotExists(connectionSource, Employee.class);
    }

    @Override
    public Employee findEmployeeByName(String name) throws SQLException {
        return super.queryBuilder().where().eq("name", name).queryForFirst();
    }

    @Override
    public List<Employee> findEmployeeByNameAndEyeColor(String name, String eyeColor) throws SQLException {
        return super.queryBuilder().where().eq("name", name).eq("eye_color", eyeColor).query();
    }

    public List<Employee> findAll() throws SQLException {
        return super.queryForAll();
    }

    public Employee findById(int id) throws SQLException {
        return super.queryBuilder().where().eq("id",id).queryForFirst();
    }

    public void save(Employee employee) throws SQLException {
        super.create(employee);
    }


}
