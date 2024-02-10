package com.example.recruitmentservice.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="EMPLOYER")
public class employer {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name="EMAIL", unique = true)
    private String email;

    @Column(name="NAME")
    private String name;

    @Column(name="PROVINCE")
    private Integer province;

    @Column(name="DESCRIPTION")
    private String description;

    @Column(name="CREATED_AT")
    private Date createAt;
}
