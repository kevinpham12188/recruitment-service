package com.example.recruitmentservice.api.controller;

import com.example.recruitmentservice.api.dto.dtoIn.PageDtoIn;
import com.example.recruitmentservice.api.dto.dtoIn.SeekerDtoIn;
import com.example.recruitmentservice.api.service.SeekerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class SeekerController extends AbstractResponseController{
    private SeekerService seekerService;
    @Autowired
    public SeekerController(SeekerService seekerService) {
        this.seekerService = seekerService;
    }

    /* Create Seeker */
    @PostMapping("/seeker/create")
    public ResponseEntity<?> createSeeker(@RequestBody @Valid SeekerDtoIn seekerDtoIn) {
        return responseEntity(
                () -> {
                    return seekerService.createSeeker(seekerDtoIn);
                }, 201, true
        );
    }

    /* Get seeker by id */
    @GetMapping("/seeker/{id}")
    public ResponseEntity<?> getSeekerById(@PathVariable(value = "id") Long id) {
        return responseEntity(
                () -> {
                    return seekerService.getSeekerById(id);
                }, 200, false
        );
    }

    /* Update seeker */
    @PutMapping("/seeker/{id}/update")
    public ResponseEntity<?> updateSeeker(@PathVariable(value = "id") Long id,
                                          @RequestBody @Valid SeekerDtoIn seekerDtoIn) {
        return responseEntity(
                () -> {
                    return seekerService.updateSeeker(id, seekerDtoIn);
                }, 200, false
        );
    }

    /* Delete seeker */
    @DeleteMapping("/seeker/{id}/delete")
    public ResponseEntity<?> deleteSeeker(@PathVariable(value = "id") Long id) {
        return responseEntity(
                () -> {
                    seekerService.deleteSeeker(id);
                    return new HashMap<>();
                }, 200, false
        );
    }

    /* Get all seekers */
    @GetMapping("/seeker/getall")
    public ResponseEntity<?> getAllSeekers(@RequestBody @Valid PageDtoIn pageDtoIn) {
        return responseEntity(
                () -> {
                    return seekerService.listOfSeekers(pageDtoIn);
                }, 201, false
        );
    }
}
