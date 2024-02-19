package com.example.recruitmentservice.api.dto.dtoIn;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployerDtoIn {
    /*
    Email should be a valid email format
    Email should not be null or empty
    */
    @Email
    @NotEmpty
    private String email;

    /*
    Name should have max 255 characters
    Name should not be null or empty
    */
    @NotEmpty
    @Size(max = 255)
    private String name;

    /* provinceId should not be null */
    @NotNull
    private Integer provinceId;
    private String description;
}
