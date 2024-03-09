package com.example.recruitmentservice.api.service;

import com.example.recruitmentservice.api.dto.dtoIn.PageDtoIn;
import com.example.recruitmentservice.api.dto.dtoIn.SeekerDtoIn;
import com.example.recruitmentservice.api.dto.dtoOut.PageDtoOut;
import com.example.recruitmentservice.api.dto.dtoOut.SeekerDtoOut;

public interface SeekerService {
    SeekerDtoOut createSeeker(SeekerDtoIn seekerDtoIn);
    SeekerDtoOut getSeekerById(Long id);
    SeekerDtoOut updateSeeker(Long id, SeekerDtoIn seekerDtoIn);
    void deleteSeeker(Long id);
    PageDtoOut<SeekerDtoOut> listOfSeekers(PageDtoIn pageDtoIn);
}
