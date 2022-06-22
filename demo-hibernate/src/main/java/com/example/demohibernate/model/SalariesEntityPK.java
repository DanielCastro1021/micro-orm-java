package com.example.demohibernate.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Date;

@Data
public class SalariesEntityPK implements Serializable {

    @Id
    @Column(name = "emp_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empNo;

    @Id
    @Column(name = "from_date")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Date fromDate;

}