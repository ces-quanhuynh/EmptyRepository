package com.bookstore.dao.impl;

import com.bookstore.dao.BookDao;
import com.bookstore.entity.AuthorEntity;
import com.bookstore.entity.BookEntity;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigInteger;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class BookDaoImpl implements BookDao {

    @PersistenceContext
    Session session;

    @Override
    public BookEntity getBookById(Integer idBook) {
        return session.get(BookEntity.class,idBook);
    }

    @Override
    public List<BookEntity> getAllBooks() {
        List<BookEntity> list;
        String sql = "select * from book";
        Query query = session.createNativeQuery(sql,BookEntity.class);
        list = query.getResultList();
        return list.stream().sorted(Comparator.comparing(BookEntity::getNameBook)).collect(Collectors.toList());
    }

    @Override
    public List<BookEntity> getBookByName(String nameBook) {
        List<BookEntity> list;
        String sql = "select * from book where namebook like ?1";
        Query query = session.createNativeQuery(sql,BookEntity.class);
        query.setParameter(1,"%"+nameBook+"%");
        list = query.getResultList();
        return list.stream().sorted(Comparator.comparing(BookEntity::getNameBook)).collect(Collectors.toList());
    }

    @Override
    public boolean saveBook(BookEntity bookEntity, Set<AuthorEntity> authorEntities) {
        boolean result = false;
        try{
            bookEntity.setAuthors(authorEntities);

            session.save(bookEntity);
            result = true;
        }catch(Exception e){
            e.printStackTrace();
            result = false;
        } finally {
            session.close();
        }
        return result;
    }

    @Override
    public boolean deleteBook(Integer idBook) {
        boolean result = false;
        try {
            BookEntity bookEntity = getBookById(idBook);
            session.delete(bookEntity);
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
    public boolean updateBook(Integer idBook, BookEntity bookEntity, Set<AuthorEntity> authorEntities) {
        boolean result = false;
        try {
            BookEntity bookEntityFind = getBookById(idBook);
            bookEntityFind.setNameBook(bookEntity.getNameBook());
            bookEntityFind.setTypeBook(bookEntity.getTypeBook());
            bookEntityFind.setAuthors(authorEntities);
            session.update(bookEntityFind);
            result = true;
        }catch (Exception e){
            e.printStackTrace();
            result = false;
        }finally {
            session.close();
        }
        return result;
    }
}
