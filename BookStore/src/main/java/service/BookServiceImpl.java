package service;

import dao.BookDao;
import dao.BookDaoImpl;
import entities.Book;

import java.util.List;

public class BookServiceImpl implements BookService{
    private BookDao bookDao;

    public BookServiceImpl(){
        bookDao = new BookDaoImpl();
    }

    @Override
    public List<Book> getAll() {
        return bookDao.getAll();
    }

    @Override
    public List<Book> getBooks(String name) {
        return bookDao.getBooks(name);
    }

    @Override
    public List<Book> getBooksByAuthor(String authorName) {
        return bookDao.getBooksByAuthor(authorName);
    }

    @Override
    public boolean insert(Book book) {
        return bookDao.insert(book);
    }

    @Override
    public boolean delete(Integer id) {
        return bookDao.delete(id);
    }

    @Override
    public boolean update(Integer id, String name, String author) {
        return bookDao.update(id,name,author);
    }
}
