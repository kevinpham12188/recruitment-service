package com.example.recruitmentservice.api.dto.dtoOut;

import com.example.recruitmentservice.api.entities.Employer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PageEmployerDtoOut {
    private Long id;
    private String email;
    private String name;
    private Integer provinceId;
    private String provinceName;

    public static PageEmployerDtoOut from(Employer employer) {
        return PageEmployerDtoOut.builder()
                .id(employer.getId())
                .email(employer.getEmail())
                .name(employer.getName())
                .provinceId(employer.getProvince())
                .build();
    }
}
