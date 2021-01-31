package com.bookstore.service.impl;

import com.bookstore.dao.AuthorDao;
import com.bookstore.dto.AuthorDTO;
import com.bookstore.entity.AuthorEntity;
import com.bookstore.service.AuthorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorDao authorDao;
    private ModelMapper modelMapper;

    @Autowired
    AuthorServiceImpl(AuthorDao authorDao,ModelMapper modelMapper){
        this.authorDao = authorDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public AuthorDTO getAuthorById(Integer idAuthor) {
        return modelMapper.map(authorDao.getAuthorById(idAuthor),AuthorDTO.class);
    }

    @Override
    public List<AuthorDTO> getAllAuthors() {
        List<AuthorEntity> list = authorDao.getAllAuthors();
        return list.stream().map(authorEntity -> modelMapper.map(authorEntity,AuthorDTO.class)).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public boolean deleteAuthor(Integer idAuthor) {
        return authorDao.deleteAuthor(idAuthor);
    }

    @Override
    @Transactional
    public boolean saveAuthor(AuthorDTO authorDTO) {
        AuthorEntity authorEntity = modelMapper.map(authorDTO,AuthorEntity.class);
        return authorDao.saveAuthor(authorEntity);
    }

    @Override
    @Transactional
    public boolean updateAuthor(Integer idAuthor, AuthorDTO authorDTO) {
        AuthorEntity authorEntity = modelMapper.map(authorDTO,AuthorEntity.class);
        return authorDao.updateAuthor(idAuthor,authorEntity);
    }
}
