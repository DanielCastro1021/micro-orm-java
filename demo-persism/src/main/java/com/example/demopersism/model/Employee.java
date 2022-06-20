package com.example.demopersism.model;

import lombok.*;
import net.sf.persism.annotations.Column;
import net.sf.persism.annotations.Table;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Table("employees")
public class Employee {
    @Column(name = "id", primary = true)
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
