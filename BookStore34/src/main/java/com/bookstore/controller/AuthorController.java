package com.bookstore.controller;

import com.bookstore.dao.AuthorDao;
import com.bookstore.dao.impl.AuthorDaoImpl;
import com.bookstore.dto.AuthorDTO;
import com.bookstore.service.AuthorService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/author")
public class AuthorController {

    AuthorService authorService;

    AuthorController(AuthorService authorService){
        this.authorService = authorService;
    }

    @RequestMapping("/list")
    public ModelAndView getAllAuthors(){
        List<AuthorDTO> list = authorService.getAllAuthors();
        ModelAndView modelAndView = new ModelAndView("AuthorJSP");
        modelAndView.addObject("listAuthors",list);
        return modelAndView;
    }

    @PostMapping
    @RequestMapping(value = "/delete/{idAuthor}")
    public String deleteAuthor(@PathVariable Integer idAuthor){
        authorService.deleteAuthor(idAuthor);
        return ("redirect:/author/list");
    }

    @RequestMapping("/new")
    public ModelAndView saveAuthorForm() {
        AuthorDTO author = new AuthorDTO();
        ModelAndView modelAndView = new ModelAndView("AuthorInsertJSP");
        modelAndView.addObject("author",author);
        modelAndView.addObject("type","save");
        return modelAndView;
    }

    @PostMapping
    @RequestMapping(value = "/save")
    public ModelAndView saveAuthor(@ModelAttribute("author") AuthorDTO authorDTO) {
        boolean key = authorService.saveAuthor(authorDTO);
        if(key){
            return getAllAuthors();
        } else {
            AuthorDTO author = new AuthorDTO();
            ModelAndView modelAndView = new ModelAndView("AuthorInsertJSP");
            modelAndView.addObject("author",author);
            modelAndView.addObject("type","save");
            modelAndView.addObject("warn","Error, try again");
            return modelAndView;
        }
    }

    @RequestMapping("/{idAuthor}")
    public ModelAndView updateAuthorForm(@PathVariable("idAuthor") Integer idAuthor){
        AuthorDTO author = authorService.getAuthorById(idAuthor);
        ModelAndView modelAndView = new ModelAndView("AuthorInsertJSP");
        modelAndView.addObject("author",author);
        modelAndView.addObject("type","edit");
        return modelAndView;
    }

    @PostMapping
    @RequestMapping(value = "/edit")
    public ModelAndView updateAuthor(@ModelAttribute("author") AuthorDTO authorDTO) {
        boolean key = authorService.updateAuthor(authorDTO.getIdAuthor(),authorDTO);
        if(key){
            return getAllAuthors();
        } else {
            AuthorDTO author = authorService.getAuthorById(authorDTO.getIdAuthor());
            ModelAndView modelAndView = new ModelAndView("AuthorInsertJSP");
            modelAndView.addObject("author",author);
            modelAndView.addObject("type","edit");
            modelAndView.addObject("warn","Error, try again");
            return modelAndView;
        }
    }


}
