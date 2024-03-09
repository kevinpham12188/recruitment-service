package com.example.recruitmentservice.api.dto.dtoIn;

import jakarta.persistence.Column;
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
public class ResumeDtoIn {
    @NotNull
    private String career_obj;

    @NotNull
    private String title;

    @NotNull
    private Long seeker_id;
}
