package com.example.library.service;

import com.example.library.model.Author;
import java.util.List;

public interface AuthorService {
    Author save(Author author);

    Author getById(Long id);

    List<Author> getAll();

    void deleteById(Long id);
}
