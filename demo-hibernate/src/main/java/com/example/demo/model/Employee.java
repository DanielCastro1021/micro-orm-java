package com.example.demo.model;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "name")
    private String name;

    @Column(name = "eye_color")
    private String eyeColor;

    public Employee(String name, String eyeColor) {
        this.name = name;
        this.eyeColor = eyeColor;
    }
}
