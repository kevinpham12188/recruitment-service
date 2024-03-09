package com.example.recruitmentservice.api.dto.dtoOut;

import com.example.recruitmentservice.api.entities.Seeker;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SeekerDtoOut {
    private Long id;
    private String name;
    private String birthday;
    private String address;
    private Integer provinceId;
    private String provinceName;

    public static SeekerDtoOut from(Seeker seeker) {
        return SeekerDtoOut.builder()
                .id(seeker.getId())
                .name(seeker.getName())
                .birthday(seeker.getBirthday())
                .address(seeker.getAddress())
                .provinceId(seeker.getProvince())
                .build();
    }
}
