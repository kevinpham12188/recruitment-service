package com.example.recruitmentservice.api.dto.dtoOut;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PageDtoOut<T> {
    @Builder.Default
    private Integer page = 1;
    private Integer pageSize = 10;
    private Long totalElements = 0L;
    private Long totalPages = 0L;
    private List<T> data = new ArrayList<>();
    public static <T> PageDtoOut<T> from(Integer page, Integer pageSize, Long totalElements, List<T> data) {
        Long totalPages = totalElements / pageSize;
        if(totalElements % pageSize != 0) {
            totalPages++;
        }
        return PageDtoOut.<T>builder().page(page)
                .pageSize(pageSize)
                .totalElements(totalElements)
                .totalPages(totalPages)
                .data(data)
                .build();
    }
}
