package com.example.recruitmentservice.api.dto.dtoIn;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SeekerDtoIn {
    @NotNull
    private String name;

    @NotNull
    private String birthday;

    private String address;

    @NotNull
    private Integer provinceId;
}
