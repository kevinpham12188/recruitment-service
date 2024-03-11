package com.example.recruitmentservice.api.service;

import com.example.recruitmentservice.api.dto.dtoIn.PageDtoIn;
import com.example.recruitmentservice.api.dto.dtoIn.ResumeDtoIn;
import com.example.recruitmentservice.api.dto.dtoOut.PageDtoOut;
import com.example.recruitmentservice.api.dto.dtoOut.ResumeDtoOut;

import java.util.List;

public interface ResumeService {
    ResumeDtoOut createResume(ResumeDtoIn resumeDtoIn);
    ResumeDtoOut getResumeById(Long id);
    ResumeDtoOut updateResume(Long id, ResumeDtoIn resumeDtoIn);
    void deleteResume(Long id);
    PageDtoOut<ResumeDtoOut> listOfResumes(PageDtoIn pageDtoIn);
    List<ResumeDtoOut> getResumeBySeekerId(Long seekerId);
}
