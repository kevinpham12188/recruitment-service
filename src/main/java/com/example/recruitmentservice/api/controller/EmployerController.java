package com.example.recruitmentservice.api.controller;

import com.example.recruitmentservice.api.entities.Employer;
import com.example.recruitmentservice.api.service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployerController {

    private EmployerService employerService;

    @Autowired
    public EmployerController(EmployerService employerService) {
        this.employerService = employerService;
    }

    /* Get all employers */
    /* Get employer by Id */
    /* Create employer */
    /* Update employer */
    /* Delete employer */

}
