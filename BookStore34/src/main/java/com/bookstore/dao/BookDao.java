package com.bookstore.dao;

import com.bookstore.entity.AuthorEntity;
import com.bookstore.entity.BookEntity;

import java.util.List;
import java.util.Set;

public interface BookDao {
    BookEntity getBookById(Integer idBook);
    List<BookEntity> getAllBooks();
    List<BookEntity> getBookByName(String nameBook);
    boolean saveBook(BookEntity bookEntity, Set<AuthorEntity> authorEntities);
    boolean deleteBook(Integer idBook);
    boolean updateBook(Integer idBook, BookEntity bookEntity, Set<AuthorEntity> authorEntities);
}
