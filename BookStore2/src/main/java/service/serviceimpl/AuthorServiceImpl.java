package service.serviceimpl;

import dao.AuthorDao;
import dao.daoimpl.AuthorDaoImpl;
import entity.AuthorEntity;
import service.AuthorService;

import java.util.List;

public class AuthorServiceImpl implements AuthorService {

    AuthorDao authorDao;

    public AuthorServiceImpl(){
        authorDao = new AuthorDaoImpl();
    }

    @Override
    public AuthorEntity getAuthorById(Integer id) {
        return authorDao.getAuthorById(id);
    }

    @Override
    public List<AuthorEntity> getAllAuthors() {
        return authorDao.getAllAuthors();
    }

    @Override
    public boolean saveAuthor(AuthorEntity authorEntity) {
        return authorDao.saveAuthor(authorEntity);
    }

    @Override
    public boolean updateAuthor(Integer id,AuthorEntity authorEntity) {
        return authorDao.updateAuthor(id,authorEntity);
    }

    @Override
    public boolean deleteAuthor(Integer id) {
        return authorDao.deleteAuthor(id);
    }
}
