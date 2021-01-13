package service.serviceimpl;

import dao.BookDao;
import dao.daoimpl.BookDaoImpl;
import entity.BookEntity;
import service.BookService;
import java.util.List;

public class BookServiceImpl implements BookService {

    BookDao bookDao = new BookDaoImpl();

    @Override
    public BookEntity getBookById(Integer id) {
        return bookDao.getBookById(id);
    }

    @Override
    public List<BookEntity> getAllBook() {
        return bookDao.getAllBook();
    }

    @Override
    public List<BookEntity> getAllBookByAuthor(Integer idAuthor) {
        return bookDao.getAllBookByAuthor(idAuthor);
    }

    @Override
    public boolean saveBook(BookEntity bookEntity) {
        return bookDao.saveBook(bookEntity);
    }

    @Override
    public boolean updateBook(Integer id, BookEntity bookEntity) {
        return bookDao.updateBook(id,bookEntity);
    }

    @Override
    public boolean deleteBook(Integer id) {
        return bookDao.deleteBook(id);
    }
}
