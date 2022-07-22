package com.example.library.dto.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BookRequestDto {
    @NotNull
    private String bookName;
    @Min(value = 0)
    private int publishedAmount;
    @Min(value = 0)
    private int soldAmount;
    @Min(value = 1)
    private Long authorId;
}
