package com.example.demohibernate.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "departments", schema = "employees")
public class DepartmentsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "dept_no")
    private String deptNo;
    @Basic
    @Column(name = "dept_name")
    private String deptName;
}
