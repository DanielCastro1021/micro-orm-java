package com.example.demohibernate.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name = "titles", schema = "employees")
@IdClass(TitlesEntityPK.class)
public class TitlesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_no")
    private int empNo;

    @Id
    @Column(name = "title")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String title;

    @Id
    @Column(name = "from_date")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Date fromDate;

    @Basic
    @Column(name = "to_date")
    private Date toDate;
}
