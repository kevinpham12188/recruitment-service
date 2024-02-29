package com.example.recruitmentservice.api.controller;

import com.example.recruitmentservice.api.dto.dtoIn.EmployerDtoIn;
import com.example.recruitmentservice.api.dto.dtoIn.PageEmployerDtoIn;
import com.example.recruitmentservice.api.service.EmployerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class EmployerController extends AbstractResponseController{

    private EmployerService employerService;

    @Autowired
    public EmployerController(EmployerService employerService) {
        this.employerService = employerService;
    }

    /* Get all employers */
    @GetMapping("/employer/getall")
    public ResponseEntity<?> getAllEmployers(@RequestBody @Valid PageEmployerDtoIn pageEmployerDtoIn) {
        return responseEntity(
                () -> {
                    return employerService.listOfEmployers(pageEmployerDtoIn);
                }, 200, false
        );
    }
    /* Get employer by id */
    @GetMapping("/employer/{id}")
    public ResponseEntity<?> getEmployerById(@PathVariable(value = "id") Long id) {
        return responseEntity(
                () -> {
                    return employerService.getEmployerById(id);
                }, 200, false
        );
    }

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
    @PutMapping("/employer/{id}/update")
    public ResponseEntity<?> updateEmployer(@PathVariable(value="id") Long id,
                                            @RequestBody @Valid EmployerDtoIn employerDtoIn) {
        return responseEntity(
                () -> {
                    return employerService.updateEmployer(id, employerDtoIn);
                }, 200, false
        );
    }
    /* Delete employer */
    @DeleteMapping("/employer/{id}/delete")
    public ResponseEntity<?> deleteEmployer(@PathVariable(value="id") Long id) {
        return responseEntity(
                () -> {
                    employerService.deleteEmployer(id);
                    return new HashMap<>();
                },200, false
        );
    }

}
