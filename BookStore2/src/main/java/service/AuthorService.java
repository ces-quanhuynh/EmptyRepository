package service;

import entity.AuthorEntity;

import java.util.List;

public interface AuthorService {
    public AuthorEntity getAuthorById(Integer id);
    public List<AuthorEntity> getAllAuthors();
    public boolean saveAuthor(AuthorEntity authorEntity);
    public boolean updateAuthor(Integer id,AuthorEntity authorEntity);
    public boolean deleteAuthor(Integer id);
}
