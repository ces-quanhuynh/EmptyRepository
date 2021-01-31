package com.bookstore.service;

import com.bookstore.dto.TypeDTO;
import com.bookstore.entity.TypeEntity;

import java.util.List;

public interface TypeService {
    List<TypeDTO> getAllTypes();
    TypeDTO getTypeById(Integer idType);
}
