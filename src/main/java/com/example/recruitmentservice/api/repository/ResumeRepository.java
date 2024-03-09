package com.example.recruitmentservice.api.repository;

import com.example.recruitmentservice.api.entities.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResumeRepository extends JpaRepository<Resume, Long> {

}
