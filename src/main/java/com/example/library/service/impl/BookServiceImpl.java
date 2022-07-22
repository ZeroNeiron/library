package com.example.library.service.impl;

import com.example.library.model.Book;
import com.example.library.repository.BookRepository;
import com.example.library.service.BookService;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book getById(Long id) {
        return bookRepository.findById(id).orElseThrow(() ->
                new NoSuchElementException("Can`t get book by id: " + id));
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> getAllByAuthorName(String authorName) {
        return bookRepository.getAllByAuthorName(authorName);
    }

    @Override
    public Book getMostSellingBookByAuthorName(String authorName) {
        return bookRepository.getMostSellingBookByAuthorName(authorName);
    }

    @Override
    public Book getMostPublishedBookByAuthorName(String authorName) {
        return bookRepository.getMostPublishedBookByAuthorName(authorName);
    }

    @Override
    public List<Book> getAllBySuccessRateOfAuthor(String authorPartName) {
        return bookRepository.getAllBooksSuccessRateOfAuthor(authorPartName);
    }

    @Override
    public List<Book> getMostPublishedBooksByAuthorPartName(String authorPartName) {
        return bookRepository.getMostPublishedBooksByAuthorPartName(authorPartName);
    }

    @Override
    public List<Book> getMostSellingBooksByAuthorPartName(String authorPartName) {
        return bookRepository.getMostSellingBooksByAuthorPartName(authorPartName);
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }
}
