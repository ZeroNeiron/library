package com.example.library.mapper.response;

import com.example.library.dto.response.BookResponseDto;
import com.example.library.model.Book;
import com.example.library.service.AuthorService;
import org.springframework.stereotype.Component;

@Component
public class BookResponseMapper {
    private final AuthorService authorService;

    public BookResponseMapper(AuthorService authorService) {
        this.authorService = authorService;
    }

    public BookResponseDto mapToDto(Book book) {
        BookResponseDto bookResponseDto = new BookResponseDto();
        bookResponseDto.setId(book.getId());
        bookResponseDto.setBookName(book.getBookName());
        bookResponseDto.setPublishedAmount(book.getPublishedAmount());
        bookResponseDto.setSoldAmount(book.getSoldAmount());
        bookResponseDto.setAuthorId(book.getAuthor().getId());
        return bookResponseDto;
    }
}