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
@Table(name = "SEEKER")
public class Seeker {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "BIRTHDAY")
    private String birthday;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "PROVINCE")
    private Integer province;

    @Column(name = "CREATED_AT")
    private Date create_at = new Date();

    @Column(name = "UPDATED_AT")
    private Date updated_at = new Date();
}
