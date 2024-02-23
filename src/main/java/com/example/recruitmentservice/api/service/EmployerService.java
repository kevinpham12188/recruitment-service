package com.example.recruitmentservice.api.service;

import com.example.recruitmentservice.api.dto.dtoIn.EmployerDtoIn;
import com.example.recruitmentservice.api.dto.dtoOut.EmployerDtoOut;
import com.example.recruitmentservice.api.entities.Employer;

import java.util.List;

public interface EmployerService {
    EmployerDtoOut createEmployer(EmployerDtoIn employerDtoIn);


}
