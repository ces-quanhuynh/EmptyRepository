package com.bookstore.service;

import com.bookstore.dto.AuthorDTO;

import java.util.List;

public interface AuthorService {
    AuthorDTO getAuthorById(Integer idAuthor);
    List<AuthorDTO> getAllAuthors();
    boolean deleteAuthor(Integer idAuthor);
    boolean saveAuthor(AuthorDTO authorDTO);
    boolean updateAuthor(Integer idAuthor,AuthorDTO authorDTO);
}
