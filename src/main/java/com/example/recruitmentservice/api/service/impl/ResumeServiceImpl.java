package com.example.recruitmentservice.api.service.impl;

import com.example.recruitmentservice.api.dto.dtoIn.PageDtoIn;
import com.example.recruitmentservice.api.dto.dtoIn.ResumeDtoIn;
import com.example.recruitmentservice.api.dto.dtoOut.PageDtoOut;
import com.example.recruitmentservice.api.dto.dtoOut.ResumeDtoOut;
import com.example.recruitmentservice.api.entities.Resume;
import com.example.recruitmentservice.api.repository.ResumeRepository;
import com.example.recruitmentservice.api.service.ResumeService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumeServiceImpl implements ResumeService {
    private ResumeRepository resumeRepository;

    @Autowired
    public ResumeServiceImpl(ResumeRepository resumeRepository) {
        this.resumeRepository = resumeRepository;
    }

    /* Create resume*/
    @Override
    public ResumeDtoOut createResume(ResumeDtoIn resumeDtoIn) {
        Resume resume = resumeRepository.save(
                Resume.builder()
                        .title(resumeDtoIn.getTitle())
                        .career_obj(resumeDtoIn.getCareer_obj())
                        .seekerId(resumeDtoIn.getSeekerId())
                        .build()
        );
        return ResumeDtoOut.from(resume);
    }

    /* Get resume by id */
    @Override
    @Cacheable(key = "#id", value = "RESUME")
    public ResumeDtoOut getResumeById(Long id) {
        Resume resume = resumeRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Resume, " + id + ", does not exist")
        );
        return ResumeDtoOut.from(resume);
    }

    /* Update resume */
    @Override
    @CachePut(key = "#id", cacheNames = "RESUME")
    public ResumeDtoOut updateResume(Long id, ResumeDtoIn resumeDtoIn) {
        Resume resume = resumeRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Resume, " + id + ", does not exist")
        );
        resume.setTitle(resumeDtoIn.getTitle());
        resume.setCareer_obj(resumeDtoIn.getCareer_obj());
        resume = resumeRepository.save(resume);
        return ResumeDtoOut.from(resume);
    }

    /* Delete resume */
    @Override
    @CacheEvict(key = "id", cacheNames = "RESUME", beforeInvocation = true)
    public void deleteResume(Long id) {
        Resume resume = resumeRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Resume, " + id + ", does not exist")
        );
        resumeRepository.delete(resume);
    }

    /* Get all resumes */
    @Override
    public PageDtoOut<ResumeDtoOut> listOfResumes(PageDtoIn pageDtoIn) {
        Page<Resume> resumes = resumeRepository.findAll(PageRequest.of(pageDtoIn.getPage() - 1,
                pageDtoIn.getPageSize(), Sort.by("id")));
        return PageDtoOut.from(pageDtoIn.getPage(),
                pageDtoIn.getPageSize(),
                resumes.getTotalElements(),
                resumes.stream().map(ResumeDtoOut::from).toList());
    }

    /* Get resumes by seeker id */
    @Override
    public List<ResumeDtoOut> getResumeBySeekerId(Long seekerId) {
        List<Resume> resumes = resumeRepository.getResumeBySeekerId(seekerId);
        return resumes.stream().map(ResumeDtoOut::from).toList();
    }
}
