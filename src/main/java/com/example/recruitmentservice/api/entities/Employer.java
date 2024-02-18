package com.example.recruitmentservice.api.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name="EMPLOYER")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="EMAIL", unique = true, length = 255)
    private String email;

    @Column(name="NAME", length = 255)
    private String name;

    @Column(name = "PROVINCE")
    private Integer provinceId;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "CREATE_AT")
    private Date createAt;

    @Column(name = "UPDATE_AT")
    private Date updateAt;
}
