package com.example.demopersism.model;

import lombok.*;
import net.sf.persism.annotations.Column;
import net.sf.persism.annotations.Table;

import java.sql.Date;


@Data
@Table("employees")
public class EmployeesEntity {

    @Column(name = "emp_no", primary = true)
    private int empNo;

    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "hire_date")
    private Date hireDate;

    @Column(name = "gender")
    private GenderEnum gender;

    public enum GenderEnum {
        M, F
    }
}
