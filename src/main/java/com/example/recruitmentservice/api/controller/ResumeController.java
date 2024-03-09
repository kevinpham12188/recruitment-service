package com.example.recruitmentservice.api.controller;

import com.example.recruitmentservice.api.dto.dtoIn.PageDtoIn;
import com.example.recruitmentservice.api.dto.dtoIn.ResumeDtoIn;
import com.example.recruitmentservice.api.service.ResumeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class ResumeController extends AbstractResponseController{
    private ResumeService resumeService;

    @Autowired
    public ResumeController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    /* Create resume */
    @PostMapping("/resume/create")
    public ResponseEntity<?> createResume(@RequestBody @Valid ResumeDtoIn resumeDtoIn) {
        return responseEntity(
                () -> {
                    return resumeService.createResume(resumeDtoIn);
                }, 201, true
        );
    }

    /* Get resume by id */
    @GetMapping("/resume/{id}")
    public ResponseEntity<?> getResumeById(@PathVariable(value = "id") Long id) {
        return responseEntity(
                () -> {
                    return resumeService.getResumeById(id);
                }, 200, false
        );
    }

    /* Update resume */
    @PutMapping("/resume/{id}/update")
    public ResponseEntity<?> updateResume(@PathVariable(value = "id") Long id,
                                          @RequestBody @Valid ResumeDtoIn resumeDtoIn) {
        return responseEntity(
                () -> {
                    return resumeService.updateResume(id, resumeDtoIn);
                }, 200, false
        );
    }

    /* Delete resume */
    @DeleteMapping("/resume/{id}/delete")
    public ResponseEntity<?> deleteResume(@PathVariable(value = "id") Long id) {
        return responseEntity(
                () -> {
                    resumeService.deleteResume(id);
                    return new HashMap<>();
                }, 200, false
        );
    }

    /* Get all resumes */
    @GetMapping("/resume/getall")
    public ResponseEntity<?> getAllResumes(@RequestBody @Valid PageDtoIn pageDtoIn) {
        return responseEntity(
                () -> {
                    return resumeService.listOfResumes(pageDtoIn);
                }, 200, false
        );
    }
}
