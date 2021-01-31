package com.bookstore.dao;

import com.bookstore.entity.TypeEntity;

import java.util.List;

public interface TypeDao {
    List<TypeEntity> getAllTypes();
    TypeEntity getTypeById(Integer idType);
}
