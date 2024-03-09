package com.example.recruitmentservice.api.repository;

import com.example.recruitmentservice.api.entities.Seeker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeekerRepository extends JpaRepository<Seeker, Long> {
}
