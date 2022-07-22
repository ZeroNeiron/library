package com.example.library.mapper.request;

import com.example.library.dto.request.BookRequestDto;
import com.example.library.model.Book;
import com.example.library.service.AuthorService;
import org.springframework.stereotype.Component;

@Component
public class BookRequestMapper {
    private final AuthorService authorService;

    public BookRequestMapper(AuthorService authorService) {
        this.authorService = authorService;
    }

    public Book mapToModel(BookRequestDto bookRequestDto) {
        Book book = new Book();
        book.setBookName(bookRequestDto.getBookName());
        book.setPublishedAmount(bookRequestDto.getPublishedAmount());
        book.setSoldAmount(bookRequestDto.getSoldAmount());
        book.setAuthor(authorService.getById(bookRequestDto.getAuthorId()));
        return book;
    }
}