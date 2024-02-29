package com.example.recruitmentservice.api.service;

import com.example.recruitmentservice.api.dto.dtoIn.EmployerDtoIn;
import com.example.recruitmentservice.api.dto.dtoIn.PageDtoIn;
import com.example.recruitmentservice.api.dto.dtoIn.PageEmployerDtoIn;
import com.example.recruitmentservice.api.dto.dtoOut.EmployerDtoOut;
import com.example.recruitmentservice.api.dto.dtoOut.PageDtoOut;
import com.example.recruitmentservice.api.dto.dtoOut.PageEmployerDtoOut;
import com.example.recruitmentservice.api.entities.Employer;

import java.util.List;

public interface EmployerService {
    EmployerDtoOut getEmployerById(Long id);
    EmployerDtoOut createEmployer(EmployerDtoIn employerDtoIn);
    EmployerDtoOut updateEmployer(Long id, EmployerDtoIn employerDtoIn);
    List<EmployerDtoOut> getAllEmployers();
    void deleteEmployer(Long id);
    PageDtoOut<EmployerDtoOut> listOfEmployers(PageEmployerDtoIn pageEmployerDtoIn);

}
