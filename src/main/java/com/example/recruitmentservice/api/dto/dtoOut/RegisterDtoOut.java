package com.example.recruitmentservice.api.dto.dtoOut;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDtoOut {
    private String username;
    private String password;
}
