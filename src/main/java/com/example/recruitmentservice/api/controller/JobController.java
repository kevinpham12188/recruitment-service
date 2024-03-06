package com.example.recruitmentservice.api.controller;

import com.example.recruitmentservice.api.dto.dtoIn.JobDtoIn;
import com.example.recruitmentservice.api.dto.dtoIn.PageDtoIn;
import com.example.recruitmentservice.api.service.JobService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class JobController extends AbstractResponseController {
    private JobService jobService;

    @Autowired
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    /* Create job */
    @PostMapping("/job/create")
    public ResponseEntity<?> createJob(@RequestBody @Valid JobDtoIn jobDtoIn) {
        return responseEntity(
                () -> {
                    return jobService.createJob(jobDtoIn);
                }, 201, true
        );
    }

    /* Get job by id */
    @GetMapping("/job/{id}")
    public ResponseEntity<?> getJobById(@PathVariable(value = "id") Long id) {
        return responseEntity(
                () -> {
                    return jobService.getJobById(id);
                }, 200, false
        );
    }

    /* Update job */
    @PutMapping("/job/{id}/update")
    public ResponseEntity<?> updateJob(@PathVariable(value = "id") Long id,
                                       @RequestBody @Valid JobDtoIn jobDtoIn) {
        return responseEntity(
                () -> {
                    return jobService.updateJob(id, jobDtoIn);
                }, 200, false
        );
    }

    /* Delete job */
    @DeleteMapping("/job/{id}/delete")
    public ResponseEntity<?> deleteJob(@PathVariable(value = "id") Long id) {
        return responseEntity(
                () -> {
                    jobService.deleteJob(id);
                    return new HashMap<>();
                }, 200, false
        );
    }

    /* Get all jobs */
    @GetMapping("/job/getall")
    public ResponseEntity<?> getAllJobs(@RequestBody @Valid PageDtoIn pageDtoIn) {
        return responseEntity(
                () -> {
                    return jobService.listOfJobs(pageDtoIn);
                }, 201, false
        );
    }


}
