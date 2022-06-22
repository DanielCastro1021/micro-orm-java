package com.example.demohibernate.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name = "dept_manager", schema = "employees")
@IdClass(DeptManagerEntityPK.class)
public class DeptManagerEntity {

    @Id
    @Column(name = "emp_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empNo;

    @Id
    @Column(name = "dept_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String deptNo;

    @Basic
    @Column(name = "from_date")
    private Date fromDate;

    @Basic
    @Column(name = "to_date")
    private Date toDate;
}
