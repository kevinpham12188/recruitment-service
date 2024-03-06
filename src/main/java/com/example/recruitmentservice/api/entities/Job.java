package com.example.recruitmentservice.api.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "JOB")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "EMPLOYER_ID")
    private Long employer_id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "QUANTITY")
    private Long quantity;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "SALARY")
    private Long salary;

    @Column(name = "FIELDS")
    private String fields;

    @Column(name = "PROVINCES")
    private String provinces;

    @Column(name = "CREATED_AT")
    private Date created_at = new Date();

    @Column(name = "UPDATED_AT")
    private Date updated_at = new Date();

    @Column(name = "EXPIRED_AT")
    private Date expired_at;


}
