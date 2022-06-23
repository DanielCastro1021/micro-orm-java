package com.example.demohibernate.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name = "salaries", schema = "employees")
@IdClass(SalariesEntityPK.class)
public class SalariesEntity {

    @Id
    @Column(name = "emp_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empNo;

    @Basic
    @Column(name = "salary")
    private int salary;

    @Id
    @Column(name = "from_date")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Date fromDate;

    @Basic
    @Column(name = "to_date")
    private Date toDate;

}
