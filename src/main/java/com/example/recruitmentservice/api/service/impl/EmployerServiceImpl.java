package com.example.recruitmentservice.api.service.impl;

import com.example.recruitmentservice.api.dto.dtoIn.EmployerDtoIn;
import com.example.recruitmentservice.api.dto.dtoIn.PageDtoIn;
import com.example.recruitmentservice.api.dto.dtoIn.PageEmployerDtoIn;
import com.example.recruitmentservice.api.dto.dtoOut.EmployerDtoOut;
import com.example.recruitmentservice.api.dto.dtoOut.PageDtoOut;
import com.example.recruitmentservice.api.dto.dtoOut.PageEmployerDtoOut;
import com.example.recruitmentservice.api.entities.Employer;
import com.example.recruitmentservice.api.repository.EmployerRepository;
import com.example.recruitmentservice.api.service.EmployerService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerServiceImpl implements EmployerService {
    private EmployerRepository employerRepository;

    @Autowired
    public EmployerServiceImpl(EmployerRepository employerRepository) {
        this.employerRepository = employerRepository;
    }

    /* Get employer by id */
    @Override
    @Cacheable(key = "#id", value = "EMPLOYER")
    public EmployerDtoOut getEmployerById(Long id) {
        Employer employer = employerRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Employer, " + id + ", does not exist.")
        );
        return EmployerDtoOut.from(employer);
    }

    /* Create employer */
    @Override
    public EmployerDtoOut createEmployer(EmployerDtoIn employerDtoIn) {
        Employer employer = employerRepository.save(
                Employer.builder()
                        .email(employerDtoIn.getEmail())
                        .name(employerDtoIn.getName())
                        .province(employerDtoIn.getProvinceId())
                        .description(employerDtoIn.getDescription())
                        .build()
        );
        return EmployerDtoOut.from(employer);
    }

    /* Update Employer */
    @Override
    public EmployerDtoOut updateEmployer(Long id, EmployerDtoIn employerDtoIn) {
        Employer employer = employerRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("employer, " + id + " does not exist.")
        );
        if(employerDtoIn.getName() != null) {
            employer.setName(employerDtoIn.getName());
        }
        if(employerDtoIn.getProvinceId() != null) {
            employer.setProvince(employerDtoIn.getProvinceId());
        }
        employer.setDescription(employerDtoIn.getDescription());
        employer = employerRepository.save(employer);
        return EmployerDtoOut.from(employer);
    }

    /* Get all employers */
    @Override
    public List<EmployerDtoOut> getAllEmployers() {
        List<Employer> employerList = employerRepository.findAll();
        return employerList.stream().map(EmployerDtoOut::from).toList();
    }

    @Override
    public PageDtoOut<EmployerDtoOut> listOfEmployers(PageEmployerDtoIn pageEmployerDtoIn) {
        Page<Employer> employers = employerRepository.findAll(PageRequest.of(pageEmployerDtoIn.getPage() - 1,
                pageEmployerDtoIn.getPageSize(), Sort.by("id").ascending()));
        return PageDtoOut.from(pageEmployerDtoIn.getPage(),
                pageEmployerDtoIn.getPageSize(),
                employers.getTotalElements(),
                employers.stream().map(EmployerDtoOut::from).toList());
    }

    /* Delete employer*/
    @Override
    public void deleteEmployer(Long id) {
        Employer employer = employerRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("employer, " + id + " does not exist.")
        );
        employerRepository.delete(employer);

    }


}
