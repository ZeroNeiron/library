package com.example.library.mapper.request;

import java.time.LocalDate;
import com.example.library.dto.request.AuthorRequestDto;
import com.example.library.model.Author;
import com.example.library.util.DateParserUtil;
import org.springframework.stereotype.Component;

@Component
public class AuthorRequestMapper {
    public Author mapToModel(AuthorRequestDto authorRequestDto) {
        Author author = new Author();
        author.setAuthorName(authorRequestDto.getAuthorName());
        author.setBirthDate(DateParserUtil.stringToDate(authorRequestDto.getBirthDate()));
        author.setEmail(authorRequestDto.getEmail());
        author.setPhone(authorRequestDto.getPhone());
        return author;
    }
}