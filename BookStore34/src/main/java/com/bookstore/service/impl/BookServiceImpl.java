package com.bookstore.service.impl;

import com.bookstore.dao.AuthorDao;
import com.bookstore.dao.BookDao;
import com.bookstore.dto.AuthorDTO;
import com.bookstore.dto.BookDTO;
import com.bookstore.entity.AuthorEntity;
import com.bookstore.entity.BookEntity;
import com.bookstore.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private BookDao bookDao;
    private AuthorDao authorDao;
    private ModelMapper modelMapper;

    @Autowired
    BookServiceImpl(BookDao bookDao, AuthorDao authorDao, ModelMapper modelMapper){
        this.bookDao = bookDao;
        this.authorDao = authorDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public BookDTO getBookById(Integer idBook) {
        BookEntity bookEntity = bookDao.getBookById(idBook);
        return modelMapper.map(bookEntity,BookDTO.class);
    }

    @Override
    public List<BookDTO> getAllBooks() {
        List<BookEntity> list = bookDao.getAllBooks();
        return list.stream().map(bookEntity -> modelMapper.map(bookEntity,BookDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<BookDTO> getBookByName(String nameBook) {
        List<BookEntity> list = bookDao.getBookByName(nameBook);
        return list.stream().map(bookEntity -> modelMapper.map(bookEntity,BookDTO.class)).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public boolean saveBook(BookDTO bookDTO, Set<AuthorDTO> authorDTOS) {
        BookEntity bookEntity = modelMapper.map(bookDTO,BookEntity.class);
        Set<AuthorEntity> authorEntities = authorDTOS.stream().map(authorDTO -> modelMapper.map(authorDTO,AuthorEntity.class)).collect(Collectors.toSet());
        return bookDao.saveBook(bookEntity,authorEntities);
    }

    @Override
    @Transactional
    public boolean deleteBook(Integer idBook) {
        return bookDao.deleteBook(idBook);
    }

    @Override
    @Transactional
    public boolean updateBook(Integer idBook, BookDTO bookDTO, Set<AuthorDTO> authorDTOS) {
        BookEntity bookEntity = modelMapper.map(bookDTO,BookEntity.class);
        Set<AuthorEntity> authorEntities = authorDTOS.stream().map(authorDTO -> modelMapper.map(authorDTO,AuthorEntity.class)).collect(Collectors.toSet());
        return bookDao.updateBook(idBook,bookEntity,authorEntities);
    }

}
