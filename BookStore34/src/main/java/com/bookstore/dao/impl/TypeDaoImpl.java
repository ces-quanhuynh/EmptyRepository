package com.bookstore.dao.impl;

import com.bookstore.dao.TypeDao;
import com.bookstore.dto.TypeDTO;
import com.bookstore.entity.TypeEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class TypeDaoImpl implements TypeDao {

    @PersistenceContext
    private Session session;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<TypeEntity> getAllTypes() {
        List<TypeEntity> list;
        String sql = "select * from type";
        Query query = session.createNativeQuery(sql, TypeEntity.class);
        list = query.getResultList();
        return list;
    }

    @Override
    public TypeEntity getTypeById(Integer idType) {
        TypeEntity typeEntity = session.get(TypeEntity.class,idType);
        return typeEntity;
    }
}
