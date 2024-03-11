package com.example.recruitmentservice.api.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "RESUME")
public class Resume {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "CAREER_OBJ")
    private String career_obj;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "CREATED_AT")
    private Date created_at = new Date();

    @Column(name = "UPDATED_AT")
    private Date updated_at = new Date();

    @Column(name = "SEEKER_ID")
    private Long seekerId;
}
