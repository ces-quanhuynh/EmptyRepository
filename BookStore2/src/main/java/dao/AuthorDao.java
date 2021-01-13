package dao;

import entity.AuthorEntity;

import java.util.List;

public interface AuthorDao {
    public AuthorEntity getAuthorById(Integer id);
    public List<AuthorEntity> getAllAuthors();
    public boolean saveAuthor(AuthorEntity authorEntity);
    public boolean updateAuthor(Integer id,AuthorEntity authorEntity);
    public boolean deleteAuthor(Integer id);
}
