package com.example.recruitmentservice.api.service.impl;

import com.example.recruitmentservice.api.entities.Employer;
import com.example.recruitmentservice.api.repository.EmployerRepository;
import com.example.recruitmentservice.api.service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerServiceImpl implements EmployerService {
    private EmployerRepository employerRepository;

    @Autowired
    public EmployerServiceImpl(EmployerRepository employerRepository) {
        this.employerRepository = employerRepository;
    }

    /* Get all employers */
    public List<Employer> getAllEmployers() {
        return employerRepository.findAll();
    }



}
