package com.example.recruitmentservice.api.dto.dtoIn;

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
public class JobDtoIn {
    @NotNull
    private Long employerId;

    @NotNull
    private String title;

    @NotNull
    private Long quantity;

    @NotNull
    private String description;

    @NotNull
    private String fieldIds;

    @NotNull
    private String provinceIds;

    @NotNull
    private Long salary;

    @NotNull
    private Date expiredAt;
}
