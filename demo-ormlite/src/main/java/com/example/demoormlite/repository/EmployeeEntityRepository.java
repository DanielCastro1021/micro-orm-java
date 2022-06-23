package com.example.demoormlite.repository;

import com.example.demoormlite.model.EmployeeEntityDao;
import com.example.demoormlite.model.EmployeesEntity;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;

@Component
public class EmployeeEntityRepository extends BaseDaoImpl<EmployeesEntity, Integer> implements EmployeeEntityDao {

    public EmployeeEntityRepository(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, EmployeesEntity.class);
        TableUtils.createTableIfNotExists(connectionSource, EmployeesEntity.class);
    }

    public long count() throws SQLException {
        return super.countOf();
    }

    public List<EmployeesEntity> findAll() throws SQLException {
        return super.queryForAll();
    }

    public EmployeesEntity findById(long id) throws SQLException {
        return super.queryBuilder().where().eq("emp_no", id).queryForFirst();
    }

    public void save(EmployeesEntity employee) throws SQLException {
        super.create(employee);
    }


}
