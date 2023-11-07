package com.company.springdatajpa.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "student")
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "surname",nullable = false)
    private String surname;

    @Column(name = "dateOfBirth",nullable = false)
    private Integer dateOfBirth;

    @Column(name = "studentNumber",nullable = false,unique = true)
    private String studentNumber;
}
