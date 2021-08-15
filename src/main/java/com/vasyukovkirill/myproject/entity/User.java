package com.vasyukovkirill.myproject.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Setter
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "surname")
    private String surName;

    @Column(name = "name")
    private String name;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "dateofbirth")
    private LocalDate dateOfBirth;

    @Column(name = "lastchange")
    private LocalDateTime lastChange;

    @Column(name = "deactivated")
    private boolean deactivated;

}
