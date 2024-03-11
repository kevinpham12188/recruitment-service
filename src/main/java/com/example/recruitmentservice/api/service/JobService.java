package com.example.recruitmentservice.api.service;

import com.example.recruitmentservice.api.dto.dtoIn.JobDtoIn;
import com.example.recruitmentservice.api.dto.dtoIn.PageDtoIn;
import com.example.recruitmentservice.api.dto.dtoOut.JobDtoOut;
import com.example.recruitmentservice.api.dto.dtoOut.PageDtoOut;

import java.util.List;

public interface JobService {
    JobDtoOut createJob(JobDtoIn jobDtoIn);
    JobDtoOut getJobById(Long id);
    JobDtoOut updateJob(Long id, JobDtoIn jobDtoIn);
    void deleteJob(Long id);
    PageDtoOut<JobDtoOut> listOfJobs(PageDtoIn pageDtoIn);
    List<JobDtoOut> getJobByEmployerId(Long employerId);
}
