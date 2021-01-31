package com.bookstore.dao.impl;

import com.bookstore.dao.AuthorDao;
import com.bookstore.dto.AuthorDTO;
import com.bookstore.entity.AuthorEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceContext;
import java.math.BigInteger;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class AuthorDaoImpl implements AuthorDao {

    @PersistenceContext
    Session session;

    @Override
    public AuthorEntity getAuthorById(Integer idAuthor) {
        AuthorEntity author = session.get(AuthorEntity.class,idAuthor);
        return author;
    }

    @Override
    public List<AuthorEntity> getAllAuthors() {
        List<AuthorEntity> list;
        String sql = "select * from author";
        Query query = session.createNativeQuery(sql, AuthorEntity.class);
        list = query.getResultList();
        return list.stream().sorted(Comparator.comparing(AuthorEntity::getNameAuthor)).collect(Collectors.toList());
    }

    @Override
    public boolean deleteAuthor(Integer idAuthor) {
        boolean result = false;
        try {
            AuthorEntity authorEntity = getAuthorById(idAuthor);
            if(authorEntity == null){
                return false;
            }
            session.delete(authorEntity);
            result = true;
        } catch (Exception e){
            e.printStackTrace();
            result = false;
        } finally {
            session.close();
        }
        return result;
    }

    @Override
    public boolean saveAuthor(AuthorEntity authorEntity) {
        if(checkExistByNameAuthor(authorEntity.getNameAuthor())){
            return false;
        }
        boolean result = false;
        try{
            session.save(authorEntity);
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
    public boolean updateAuthor(Integer idAuthor, AuthorEntity authorEntity) {
        if(checkExistByNameAuthor(authorEntity.getNameAuthor())){
            return false;
        }
        boolean result = false;
        try {
            AuthorEntity authorEntityFind = getAuthorById(idAuthor);
            authorEntityFind.setNameAuthor(authorEntity.getNameAuthor());
            session.update(authorEntityFind);
            result = true;
        }catch(Exception e){
            e.printStackTrace();
            result = false;
        }finally {
            session.close();
        }
        return result;
    }

    boolean checkExistByNameAuthor(String authorName){
        String sql = "select count(*) from author where nameauthor=?1";
        Query query = session.createNativeQuery(sql);
        query.setParameter(1,authorName);
        int count = ((BigInteger)query.uniqueResult()).intValue();
        return count>0?true:false;
    }
}
