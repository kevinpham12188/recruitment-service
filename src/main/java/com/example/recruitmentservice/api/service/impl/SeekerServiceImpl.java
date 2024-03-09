package com.example.recruitmentservice.api.service.impl;

import com.example.recruitmentservice.api.dto.dtoIn.PageDtoIn;
import com.example.recruitmentservice.api.dto.dtoIn.SeekerDtoIn;
import com.example.recruitmentservice.api.dto.dtoOut.PageDtoOut;
import com.example.recruitmentservice.api.dto.dtoOut.SeekerDtoOut;
import com.example.recruitmentservice.api.entities.Seeker;
import com.example.recruitmentservice.api.repository.SeekerRepository;
import com.example.recruitmentservice.api.service.SeekerService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class SeekerServiceImpl implements SeekerService {
    private SeekerRepository seekerRepository;

    @Autowired
    public SeekerServiceImpl(SeekerRepository seekerRepository) {
        this.seekerRepository = seekerRepository;
    }

    /* Create Seeker*/
    @Override
    public SeekerDtoOut createSeeker(SeekerDtoIn seekerDtoIn) {
        Seeker seeker = seekerRepository.save(
                Seeker.builder()
                        .name(seekerDtoIn.getName())
                        .birthday(seekerDtoIn.getBirthday())
                        .address(seekerDtoIn.getAddress())
                        .province(seekerDtoIn.getProvinceId())
                        .build()
        );
        return SeekerDtoOut.from(seeker);
    }


    /* Get seeker by Id */
    @Override
    public SeekerDtoOut getSeekerById(Long id) {
        Seeker seeker = seekerRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Seeker, " + id + " does not exist.")

        );
        return SeekerDtoOut.from(seeker);
    }

    /* Update seeker */
    @Override
    public SeekerDtoOut updateSeeker(Long id, SeekerDtoIn seekerDtoIn) {
        Seeker seeker = seekerRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Seeker, " + id + " does not exist.")

        );
        seeker.setName(seekerDtoIn.getName());
        seeker.setBirthday(seekerDtoIn.getBirthday());
        seeker.setAddress(seekerDtoIn.getAddress());
        seeker.setProvince(seekerDtoIn.getProvinceId());
        seeker = seekerRepository.save(seeker);
        return SeekerDtoOut.from(seeker);
    }

    /* Delete seeker */
    @Override
    public void deleteSeeker(Long id) {
        Seeker seeker = seekerRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Seeker, " + id + " does not exist.")

        );
        seekerRepository.delete(seeker);
    }

    /* Get all seekers */
    @Override
    public PageDtoOut<SeekerDtoOut> listOfSeekers(PageDtoIn pageDtoIn) {
        Page<Seeker> seekers = seekerRepository.findAll(PageRequest.of(pageDtoIn.getPage() - 1,
                pageDtoIn.getPageSize(), Sort.by("id").ascending()));
        return PageDtoOut.from(pageDtoIn.getPage(),
                pageDtoIn.getPageSize(),
                seekers.getTotalElements(),
                seekers.stream().map(SeekerDtoOut::from).toList());
    }
}
