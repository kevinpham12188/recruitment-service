package com.example.recruitmentservice.api.dto.dtoOut;

import com.example.recruitmentservice.api.entities.Resume;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResumeDtoOut {
    private Long id;
    private String career_obj;
    private String title;
    private Long seeker_id;

    public static ResumeDtoOut from(Resume resume) {
        return ResumeDtoOut.builder()
                .id(resume.getId())
                .career_obj(resume.getCareer_obj())
                .title(resume.getTitle())
                .seeker_id(resume.getSeeker_id())
                .build();
    }
}
