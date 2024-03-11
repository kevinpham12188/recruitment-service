package com.example.recruitmentservice.api.dto.dtoOut;

import com.example.recruitmentservice.api.entities.Job;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobDtoOut {
    private Long id;
    private String title;
    private Long quantity;
    private String description;
    private String fields;
    private String provinces;
    private Long salary;
    private Date expiredAt;
    private Long employerId;
    private String employerName;

    public static JobDtoOut from(Job job) {
        return JobDtoOut.builder()
                .id(job.getId())
                .title(job.getTitle())
                .quantity(job.getQuantity())
                .description(job.getDescription())
                .fields(job.getFields())
                .provinces(job.getProvinces())
                .salary(job.getSalary())
                .expiredAt(job.getExpired_at())
                .employerId(job.getEmployerId())
                .build();
    }
}
