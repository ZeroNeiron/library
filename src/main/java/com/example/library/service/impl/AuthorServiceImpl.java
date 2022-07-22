package com.example.library.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import com.example.library.model.Author;
import com.example.library.repository.AuthorRepository;
import com.example.library.service.AuthorService;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {
    private AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author getById(Long id) {
        return authorRepository.findById(id).orElseThrow(() ->
                new NoSuchElementException("Can`t get author by id: " + id));
    }

    @Override
    public List<Author> getAll() {
        return authorRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        authorRepository.deleteById(id);
    }
}
