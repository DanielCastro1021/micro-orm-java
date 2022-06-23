package com.example.demohibernate.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Data
public class DeptEmpEntityPK implements Serializable {

    @Id
    @Column(name = "emp_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empNo;

    @Id
    @Column(name = "dept_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String deptNo;

}
