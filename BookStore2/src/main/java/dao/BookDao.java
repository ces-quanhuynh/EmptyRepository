package dao;

import entity.BookEntity;

import java.util.List;

public interface BookDao {
    public BookEntity getBookById(Integer id);
    public List<BookEntity> getAllBook();
    public List<BookEntity> getAllBookByAuthor(Integer idAuthor);
    public boolean saveBook(BookEntity bookEntity);
    public boolean updateBook(Integer id,BookEntity bookEntity);
    public boolean deleteBook(Integer id);
}
