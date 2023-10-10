package com.spring.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", unique = true, nullable = false, length = 21)
    private String name;

    @Column(name = "age", unique = false)
    private byte age;

    @Column(name = "salary")
    private double salary;

    public Person(String name, byte age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
}
