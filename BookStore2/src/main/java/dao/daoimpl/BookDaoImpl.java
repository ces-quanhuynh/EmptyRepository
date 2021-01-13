package dao.daoimpl;

import dao.BookDao;
import entity.AuthorEntity;
import entity.BookEntity;
import entity.TypeEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BookDaoImpl implements BookDao {
    @Override
    public BookEntity getBookById(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.get(BookEntity.class,id);
    }

    @Override
    public List<BookEntity> getAllBook() {
        List<BookEntity> list;
        Session session = HibernateUtil.getSessionFactory().openSession();
        String sql = "select * from test.book";
        Query query = session.createNativeQuery(sql,BookEntity.class);
        list = query.getResultList();
        return list.stream().sorted(Comparator.comparing(BookEntity::getNameBook)).collect(Collectors.toList());
    }

    @Override
    public List<BookEntity> getAllBookByAuthor(Integer idAuthor) {
        List<BookEntity> list;
        Session session = HibernateUtil.getSessionFactory().openSession();
        String sql = "select * from test.book where idauthor = "+idAuthor;
        Query query = session.createNativeQuery(sql,BookEntity.class);
        list = query.getResultList();
        return list;
    }

    @Override
    public boolean saveBook(BookEntity bookEntity) {
        if(!checkBookNotAvailable(bookEntity)){
            return false;
        }
        boolean result = false;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.save(bookEntity);
            transaction.commit();
            result = true;
        }catch (Exception e){
            e.printStackTrace();
            result = false;
        }finally {
            session.close();
        }
        return result;
    }

    @Override
    public boolean updateBook(Integer id, BookEntity bookEntity) {
        if(!checkBookNotAvailable(bookEntity)){
            return false;
        }
        boolean result = false;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try{
            BookEntity bookEntityFind = session.find(BookEntity.class,id);
            bookEntityFind.setNameBook(bookEntity.getNameBook());
            bookEntityFind.setAuthorBook(bookEntity.getAuthorBook());
            bookEntityFind.setTypeBook(bookEntity.getTypeBook());
            session.update(bookEntityFind);
            transaction.commit();
            result = true;
        }catch (Exception e){
            e.printStackTrace();
            result = false;
        }finally {
            session.close();
        }
        return result;
    }

    @Override
    public boolean deleteBook(Integer id) {
        boolean result = false;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            BookEntity bookEntity = getBookById(id);
            session.delete(bookEntity);
            transaction.commit();
            result = true;
        }catch (Exception e){
            e.printStackTrace();
            result = false;
        }finally {
            session.close();
        }
        return result;
    }

    boolean checkBookNotAvailable(BookEntity bookEntity){
        List<BookEntity> list = getAllBook();
        BookEntity bookCheckedAvailable = list.stream().filter(book->book.getNameBook().equals(bookEntity.getNameBook())
                &&book.getAuthorBook().getNameAuthor().equals(bookEntity.getAuthorBook().getNameAuthor())
                &&book.getTypeBook().getNameType().equals(bookEntity.getTypeBook().getNameType()))
                .findAny().orElse(null);
        return bookCheckedAvailable==null?true:false;
    }
}
