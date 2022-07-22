package com.example.library.controller;

import com.example.library.dto.request.AuthorRequestDto;
import com.example.library.dto.response.AuthorResponseDto;
import com.example.library.mapper.request.AuthorRequestMapper;
import com.example.library.mapper.response.AuthorResponseMapper;
import com.example.library.model.Author;
import com.example.library.service.AuthorService;
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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    private AuthorService authorService;
    private AuthorRequestMapper authorRequestMapper;
    private AuthorResponseMapper authorResponseMapper;

    public AuthorController(AuthorService authorService,
                            AuthorRequestMapper authorRequestMapper,
                            AuthorResponseMapper authorResponseMapper) {
        this.authorService = authorService;
        this.authorRequestMapper = authorRequestMapper;
        this.authorResponseMapper = authorResponseMapper;
    }

    @GetMapping
    public List<AuthorResponseDto> getAll() {
        return authorService.getAll()
                .stream()
                .map(authorResponseMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public AuthorResponseDto save(@RequestBody @Valid AuthorRequestDto authorRequestDto) {
        return authorResponseMapper.mapToDto(
                authorService.save(authorRequestMapper.mapToModel(authorRequestDto)));
    }

    @GetMapping("/{id}")
    public AuthorResponseDto getById(@PathVariable Long id) {
        return authorResponseMapper.mapToDto(authorService.getById(id));
    }

    @PutMapping("/{id}")
    public AuthorResponseDto updateAuthor(@PathVariable Long id,
                                          @Valid @RequestBody AuthorRequestDto authorRequestDto) {
        Author author = authorRequestMapper.mapToModel(authorRequestDto);
        author.setId(id);
        return authorResponseMapper.mapToDto(authorService.save(author));
    }

    @DeleteMapping("/{id}")
    public String deleteAuthorById(@PathVariable Long id) {
        authorService.deleteById(id);
        return "Author by id " + id + " is deleted";
    }
}
