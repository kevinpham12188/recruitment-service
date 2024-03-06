package com.example.recruitmentservice.api.repository;

import com.example.recruitmentservice.api.entities.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}
