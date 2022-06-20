package com.example.demoormlite.model;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface EmployeeDao extends Dao<Employee, Integer> {

    Employee findEmployeeByName(String name) throws SQLException;

    List<Employee> findEmployeeByNameAndEyeColor(String name, String eyeColor) throws SQLException;
}
