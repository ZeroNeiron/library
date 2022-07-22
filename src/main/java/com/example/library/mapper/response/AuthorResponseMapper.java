package com.example.library.mapper.response;

import com.example.library.dto.response.AuthorResponseDto;
import com.example.library.model.Author;
import com.example.library.util.DateParserUtil;
import org.springframework.stereotype.Component;

@Component
public class AuthorResponseMapper {
    public AuthorResponseDto mapToDto(Author author) {
        AuthorResponseDto authorResponseDto = new AuthorResponseDto();
        authorResponseDto.setId(author.getId());
        authorResponseDto.setAuthorName(author.getAuthorName());
        authorResponseDto.setBirthDate(DateParserUtil.dateToString(author.getBirthDate()));
        authorResponseDto.setEmail(author.getEmail());
        authorResponseDto.setPhone(author.getPhone());
        return authorResponseDto;
    }
}