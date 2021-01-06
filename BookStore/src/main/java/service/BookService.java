package service;

import entities.Book;

import java.util.List;

public interface BookService {
    List<Book> getAll();
    List<Book> getBooks(String name);
    List<Book> getBooksByAuthor(String authorName);
    boolean insert(Book book);
    boolean delete(Integer id);
    boolean update(Integer id, String name, String author);
}
