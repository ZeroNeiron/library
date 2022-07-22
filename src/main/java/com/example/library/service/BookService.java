package com.example.library.service;

import java.util.List;
import com.example.library.model.Book;

public interface BookService {
    Book save(Book book);

    Book getById(Long id);

    List<Book> getAll();

    List<Book> getAllByAuthorName(String name);

    Book getMostSellingBookByAuthorName(String authorName);

    Book getMostPublishedBookByAuthorName(String authorName);

    List<Book> getAllBySuccessRateOfAuthor(String authorName);

    List<Book> getMostPublishedBooksByAuthorPartName(String authorName);

    List<Book> getMostSellingBooksByAuthorPartName(String authorName);

    void deleteById(Long id);
}
