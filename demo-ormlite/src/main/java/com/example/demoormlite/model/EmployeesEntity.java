package com.example.demoormlite.model;

import com.example.demoormlite.repository.EmployeeEntityRepository;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.Data;

import java.sql.Date;

@Data
@DatabaseTable(tableName = "employees", schemaName = "employees", daoClass = EmployeeEntityRepository.class)
public class EmployeesEntity {

    @DatabaseField(columnName = "emp_no", allowGeneratedIdInsert = true, generatedId = true, unique = true)
    private int empNo;

    @DatabaseField(columnName = "birth_date")
    private Date birthDate;

    @DatabaseField(columnName = "first_name")
    private String firstName;

    @DatabaseField(columnName = "last_name")
    private String lastName;

    @DatabaseField(columnName = "gender", dataType = DataType.ENUM_STRING)
    private GenderEnum gender;

    @DatabaseField(columnName = "hire_date")
    private Date hireDate;

    public enum GenderEnum {
        M, F
    }
}
