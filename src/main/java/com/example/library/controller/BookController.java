package com.example.library.controller;

import com.example.library.dto.request.BookRequestDto;
import com.example.library.dto.response.BookResponseDto;
import com.example.library.mapper.request.BookRequestMapper;
import com.example.library.mapper.response.BookResponseMapper;
import com.example.library.model.Book;
import com.example.library.service.AuthorService;
import com.example.library.service.BookService;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {
    private BookService bookService;
    private BookRequestMapper bookRequestMapper;

    private BookResponseMapper bookResponseMapper;
    private AuthorService authorService;

    public BookController(BookService bookService,
                          BookRequestMapper bookRequestMapper,
                          BookResponseMapper bookResponseMapper,
                          AuthorService authorService) {
        this.bookService = bookService;
        this.bookRequestMapper = bookRequestMapper;
        this.bookResponseMapper = bookResponseMapper;
        this.authorService = authorService;
    }

    @GetMapping("/{id}")
    public BookResponseDto getById(@PathVariable Long id) {
        return bookResponseMapper.mapToDto(bookService.getById(id));
    }

    @GetMapping
    public List<BookResponseDto> getAll() {
        return bookService.getAll().stream()
                .map(bookResponseMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/by-author-name")
    public List<BookResponseDto> getAllByAuthorName(@RequestParam String authorName) {
        return bookService.getAllByAuthorName(authorName).stream()
                .map(bookResponseMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/most-selling")
    public BookResponseDto getMostSellingBookByAuthorName(@RequestParam String authorName) {
        return bookResponseMapper.mapToDto(bookService.getMostSellingBookByAuthorName(authorName));
    }

    @GetMapping("/most-published")
    public BookResponseDto getMostPublishedBookByAuthorName(@RequestParam String authorName) {
        return bookResponseMapper.mapToDto(
                bookService.getMostPublishedBookByAuthorName(authorName));
    }

    @GetMapping("/most-success-rate")
    public List<BookResponseDto> getAllBySuccessRateOfAuthor(@RequestParam String authorPartName) {
        return bookService.getAllBySuccessRateOfAuthor(authorPartName).stream()
                .map(bookResponseMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/most-published/by-part-name")
    public List<BookResponseDto> getMostPublishedBooksByAuthorPartName(
            @RequestParam String authorPartName) {
        return bookService.getMostPublishedBooksByAuthorPartName(authorPartName).stream()
                .map(bookResponseMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/most-selling/by-part-name")
    public List<BookResponseDto> getMostSellingBooksByAuthorPartName(
            @RequestParam String authorPartName) {
        return bookService.getMostSellingBooksByAuthorPartName(authorPartName).stream()
                .map(bookResponseMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @PostMapping()
    public BookResponseDto save(@RequestBody BookRequestDto bookRequestDto) {
        return bookResponseMapper.mapToDto(
                bookService.save(bookRequestMapper.mapToModel(bookRequestDto)));
    }

    @PutMapping("/{id}")
    public BookResponseDto updateBook(@PathVariable Long id,
                                      @Valid @RequestBody BookRequestDto bookRequestDto) {
        Book book = bookRequestMapper.mapToModel(bookRequestDto);
        book.setId(id);
        return bookResponseMapper.mapToDto(bookService.save(book));
    }

    @DeleteMapping("/{id}")
    public String deleteBookById(@PathVariable Long id) {
        bookService.deleteById(id);
        return "Book by id " + id + " was deleted";
    }
}
