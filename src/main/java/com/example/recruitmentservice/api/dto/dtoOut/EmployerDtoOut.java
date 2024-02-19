package com.example.recruitmentservice.api.dto.dtoOut;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployerDtoOut {
    private Long id;
    private String email;
    private String name;
    private Integer provinceId;
    private String provinceName;
    private String description;
}
