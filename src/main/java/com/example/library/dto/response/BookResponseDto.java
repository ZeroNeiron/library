package com.example.library.dto.response;

import lombok.Data;

@Data
public class BookResponseDto {
    private Long id;
    private String bookName;
    private int publishedAmount;
    private int soldAmount;
    private Long authorId;
}
