package com.example.demoormlite.model;

import com.example.demoormlite.repository.EmployeeRepository;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@DatabaseTable(tableName = "employees", daoClass = EmployeeRepository.class)
public class Employee {
    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(columnName = "name", canBeNull = false)
    private String name;

    @DatabaseField(columnName = "eye_color", canBeNull = false)
    private String eyeColor;

    public Employee(String name, String eyeColor) {
        this.name = name;
        this.eyeColor = eyeColor;
    }
}
