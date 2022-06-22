package com.example.demohibernate.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name = "employees", schema = "employees")
public class EmployeesEntity {

    @Id
    @Column(name = "emp_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empNo;

    @Basic
    @Column(name = "birth_date")
    private Date birthDate;

    @Basic
    @Column(name = "first_name")
    private String firstName;

    @Basic
    @Column(name = "last_name")
    private String lastName;

    @Basic
    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private GenderEnum gender;

    @Basic
    @Column(name = "hire_date")
    private Date hireDate;

    public enum GenderEnum {
        M, F
    }
}
