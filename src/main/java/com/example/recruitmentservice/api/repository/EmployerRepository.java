package com.example.recruitmentservice.api.repository;

import com.example.recruitmentservice.api.entities.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerRepository extends JpaRepository<Employer, Long> {
}
