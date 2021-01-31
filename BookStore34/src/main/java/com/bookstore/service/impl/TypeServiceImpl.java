package com.bookstore.service.impl;

import com.bookstore.dao.TypeDao;
import com.bookstore.dto.TypeDTO;
import com.bookstore.entity.TypeEntity;
import com.bookstore.service.TypeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TypeServiceImpl implements TypeService {

    TypeDao typeDao;
    ModelMapper modelMapper;

    @Autowired
    TypeServiceImpl(TypeDao typeDao, ModelMapper modelMapper){
        this.modelMapper = modelMapper;
        this.typeDao = typeDao;
    }

    @Override
    @Transactional
    public List<TypeDTO> getAllTypes() {
        List<TypeEntity> list = typeDao.getAllTypes();
        return list.stream().map(typeEntity -> modelMapper.map(typeEntity,TypeDTO.class)).collect(Collectors.toList());
    }

    @Override
    public TypeDTO getTypeById(Integer idType) {
        return modelMapper.map(typeDao.getTypeById(idType),TypeDTO.class);
    }
}
