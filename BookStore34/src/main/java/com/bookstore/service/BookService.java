package com.bookstore.service;

import com.bookstore.dto.AuthorDTO;
import com.bookstore.dto.BookDTO;
import com.bookstore.entity.AuthorEntity;
import com.bookstore.entity.BookEntity;

import java.util.List;
import java.util.Set;

public interface BookService {
    BookDTO getBookById(Integer idBook);
    List<BookDTO> getAllBooks();
    List<BookDTO> getBookByName(String nameBook);
    boolean saveBook(BookDTO bookDTO, Set<AuthorDTO> authorDTOS);
    boolean deleteBook(Integer idBook);
    boolean updateBook(Integer idBook, BookDTO bookDTO,Set<AuthorDTO> authorDTOS);
}
