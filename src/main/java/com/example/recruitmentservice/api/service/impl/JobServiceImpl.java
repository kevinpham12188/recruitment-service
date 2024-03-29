package com.example.recruitmentservice.api.service.impl;

import com.example.recruitmentservice.api.dto.dtoIn.JobDtoIn;
import com.example.recruitmentservice.api.dto.dtoIn.PageDtoIn;
import com.example.recruitmentservice.api.dto.dtoOut.JobDtoOut;
import com.example.recruitmentservice.api.dto.dtoOut.PageDtoOut;
import com.example.recruitmentservice.api.entities.Job;
import com.example.recruitmentservice.api.repository.JobRepository;
import com.example.recruitmentservice.api.service.JobService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {
    private JobRepository jobRepository;
    @Autowired
    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    /* Create job */
    @Override
    public JobDtoOut createJob(JobDtoIn jobDtoIn) {
        Job job = jobRepository.save(
                Job.builder()
                        .title(jobDtoIn.getTitle())
                        .employerId(jobDtoIn.getEmployerId())
                        .quantity(jobDtoIn.getQuantity())
                        .description(jobDtoIn.getDescription())
                        .fields(jobDtoIn.getFieldIds())
                        .provinces(jobDtoIn.getProvinceIds())
                        .salary(jobDtoIn.getSalary())
                        .expired_at(jobDtoIn.getExpiredAt())
                        .build()
        );
        return JobDtoOut.from(job);
    }

    /* Get job by id */
    @Override
    @Cacheable(key = "#id", value = "JOB")
    public JobDtoOut getJobById(Long id) {
        Job job = jobRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Job, " + id + " , does not exist." )
        );
        return JobDtoOut.from(job);
    }


    /* Update job */
    @Override
    @CachePut(key = "#id", cacheNames = "JOB")
    public JobDtoOut updateJob(Long id, JobDtoIn jobDtoIn) {
        Job job = jobRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Job, " + id + " , does not exist.")
        );
        job.setTitle(jobDtoIn.getTitle());
        job.setEmployerId(jobDtoIn.getEmployerId());
        job.setQuantity(jobDtoIn.getQuantity());
        job.setDescription(jobDtoIn.getDescription());
        job.setFields(jobDtoIn.getFieldIds());
        job.setProvinces(jobDtoIn.getProvinceIds());
        job.setSalary(jobDtoIn.getSalary());
        job.setExpired_at(jobDtoIn.getExpiredAt());

        job = jobRepository.save(job);
        return JobDtoOut.from(job);
    }

    /* Delete job*/
    @Override
    @CacheEvict(key = "#id", cacheNames = "JOB", beforeInvocation = true)
    public void deleteJob(Long id) {
        Job job = jobRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Job, " + id + " , does not exist.")
        );
        jobRepository.delete(job);

    }


    /* Get all jobs */
    @Override
    public PageDtoOut<JobDtoOut> listOfJobs(PageDtoIn pageDtoIn) {
        Page<Job> jobs = jobRepository.findAll(PageRequest.of(pageDtoIn.getPage() - 1,
                pageDtoIn.getPageSize(), Sort.by("id").ascending()));
        return PageDtoOut.from(pageDtoIn.getPage(),
                pageDtoIn.getPageSize(),
                jobs.getTotalElements(),
                jobs.stream().map(JobDtoOut::from).toList());
    }

    /* Get job by employer id */
    @Override
    public List<JobDtoOut> getJobByEmployerId(Long employerId) {
        List<Job> jobs = jobRepository.getJobByEmployerId(employerId);
        return jobs.stream().map(JobDtoOut::from).toList();
    }
}
