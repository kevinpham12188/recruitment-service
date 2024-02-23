package com.example.recruitmentservice.api.service.impl;

import com.example.recruitmentservice.api.dto.dtoIn.EmployerDtoIn;
import com.example.recruitmentservice.api.dto.dtoOut.EmployerDtoOut;
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

    /* Create employer */
    @Override
    public EmployerDtoOut createEmployer(EmployerDtoIn employerDtoIn) {
        Employer employer = employerRepository.save(
                Employer.builder()
                        .email(employerDtoIn.getEmail())
                        .name(employerDtoIn.getName())
                        .province(employerDtoIn.getProvinceId())
                        .description(employerDtoIn.getDescription())
                        .build()
        );
        return EmployerDtoOut.from(employer);
    }






}
