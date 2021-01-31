package com.bookstore.dao;

import com.bookstore.entity.AuthorEntity;

import java.util.List;

public interface AuthorDao {
    AuthorEntity getAuthorById(Integer idAuthor);
    List<AuthorEntity> getAllAuthors();
    boolean deleteAuthor(Integer idAuthor);
    boolean saveAuthor(AuthorEntity authorEntity);
    boolean updateAuthor(Integer idAuthor,AuthorEntity authorEntity);
}
