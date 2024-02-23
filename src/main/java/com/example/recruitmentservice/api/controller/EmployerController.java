package com.example.recruitmentservice.api.controller;

import com.example.recruitmentservice.api.dto.dtoIn.EmployerDtoIn;
import com.example.recruitmentservice.api.service.EmployerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployerController extends AbstractResponseController{

    private EmployerService employerService;

    @Autowired
    public EmployerController(EmployerService employerService) {
        this.employerService = employerService;
    }

    /* Get all employers */
    /* Get employer by Id */
    /* Create employer */
    @PostMapping("/employer/create")
    public ResponseEntity<?> createEmployer(@RequestBody @Valid EmployerDtoIn employerDtoIn) {
        return responseEntity(
                () -> {
                    return employerService.createEmployer(employerDtoIn);
                }, 201, true
        );
    }
    /* Update employer */
    /* Delete employer */

}
