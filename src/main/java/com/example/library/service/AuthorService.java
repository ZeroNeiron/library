package com.example.library.service;

import java.util.List;
import com.example.library.model.Author;

public interface AuthorService {
    Author save(Author author);

    Author getById(Long id);

    List<Author> getAll();

    void deleteById(Long id);
}
