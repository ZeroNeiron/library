package com.example.library.repository;

import com.example.library.model.Book;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query(value = "SELECT b "
            + "FROM Book b "
            + "WHERE b.author.authorName = :authorName")
    List<Book> getAllByAuthorName(String authorName);

    @Query(value = "SELECT b "
            + "FROM Book b "
            + "WHERE b.author.authorName = :authorName AND "
            + "b.soldAmount = (SELECT MAX(book.soldAmount) FROM Book book "
            + "WHERE book.author.authorName = :authorName)")
    Book getMostSellingBookByAuthorName(String authorName);

    @Query(value = "SELECT b "
            + "FROM Book b "
            + "WHERE b.author.authorName LIKE %:authorName% AND "
            + "b.soldAmount = (SELECT MAX(book.soldAmount) FROM Book book "
            + "WHERE book.author.authorName = b.author.authorName)")
    List<Book> getMostSellingBooksByAuthorPartName(String authorName);

    @Query(value = "SELECT b "
            + "FROM Book b "
            + "WHERE b.author.authorName = :authorName AND "
            + "b.publishedAmount = (SELECT MAX(book.publishedAmount) FROM Book book "
            + "WHERE book.author.authorName = :authorName)")
    Book getMostPublishedBookByAuthorName(String authorName);

    @Query(value = "SELECT b "
            + "FROM Book b "
            + "WHERE b.author.authorName LIKE %:authorName% AND "
            + "b.publishedAmount = (SELECT MAX(book.publishedAmount) FROM Book book "
            + "WHERE book.author.authorName = b.author.authorName)")
    List<Book> getMostPublishedBooksByAuthorPartName(String authorName);

    @Query(value = "SELECT b "
            + "FROM Book b "
            + "WHERE b.author.authorName LIKE %:authorName% AND "
            + "(b.soldAmount / b.publishedAmount) = "
            + "(SELECT MAX(book.soldAmount / book.publishedAmount) FROM Book book "
            + "WHERE book.author.authorName = b.author.authorName)")
    List<Book> getAllBooksSuccessRateOfAuthor(String authorName);

}
