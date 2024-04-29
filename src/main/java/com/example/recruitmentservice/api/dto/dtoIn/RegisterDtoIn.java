package com.example.recruitmentservice.api.dto.dtoIn;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDtoIn {
    private String username;
    private String password;
}
