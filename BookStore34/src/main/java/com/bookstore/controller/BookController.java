package com.bookstore.controller;

import com.bookstore.dto.AuthorDTO;
import com.bookstore.dto.BookDTO;
import com.bookstore.dto.TypeDTO;
import com.bookstore.service.AuthorService;
import com.bookstore.service.BookService;
import com.bookstore.service.TypeService;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/book")
public class BookController {

    BookService bookService;
    TypeService typeService;
    AuthorService authorService;

    BookController(BookService bookService,TypeService typeService, AuthorService authorService){
        this.bookService = bookService;
        this.typeService = typeService;
        this.authorService = authorService;
    }

    @RequestMapping("/list")
    public ModelAndView getAllBook(){
        List<BookDTO> books = bookService.getAllBooks();
        ModelAndView modelAndView = new ModelAndView("BookJSP");
        modelAndView.addObject("listBooks",books);
        return modelAndView;
    }

    @RequestMapping("/search")
    public ModelAndView getBookByName(@RequestParam String namebook){
        List<BookDTO> books = bookService.getBookByName(namebook);
        ModelAndView modelAndView = new ModelAndView("BookSearchJSP");
        modelAndView.addObject("listBooksSearch",books);
        return modelAndView;
    }

    @RequestMapping("/new")
    public ModelAndView saveBookForm() {
        BookDTO book = new BookDTO();
        List<TypeDTO> types = typeService.getAllTypes();
        List<AuthorDTO> authors = authorService.getAllAuthors();

        ModelAndView modelAndView = new ModelAndView("BookInsertJSP");

        modelAndView.addObject("book",book);
        modelAndView.addObject("types",types);
        modelAndView.addObject("authors",authors);
        modelAndView.addObject("type","save");
        return modelAndView;
    }

    @PostMapping
    @RequestMapping(value = "/save")
    public String saveBook(@ModelAttribute("book") BookDTO bookDTO,
                            @Nullable @RequestParam("author") Integer[] idAuthors,
                            @RequestParam("type") Integer idType) {

        Set<AuthorDTO> authors = new HashSet<>();
        for (Integer idAuthor:idAuthors) {
            authors.add(authorService.getAuthorById(idAuthor));
        }

        TypeDTO type = typeService.getTypeById(idType);

        bookDTO.setTypebook(type);
        bookService.saveBook(bookDTO,authors);

        return ("redirect:/book/list");
    }

    @PostMapping
    @RequestMapping("/delete/{idBook}")
    public String deleteBook(@PathVariable Integer idBook){
        bookService.deleteBook(idBook);
        return "redirect:/book/list";
    }

    @PostMapping
    @RequestMapping("/{idBook}")
    public ModelAndView updateBookForm(@PathVariable Integer idBook){
        BookDTO bookDTO = bookService.getBookById(idBook);
        List<String> nameAuthorsOfBook = new ArrayList<>();
        for (AuthorDTO authorDTO:bookDTO.getAuthors()) {
            nameAuthorsOfBook.add(authorDTO.getNameAuthor());
        }
        List<TypeDTO> types = typeService.getAllTypes();
        List<AuthorDTO> authors = authorService.getAllAuthors();

        ModelAndView modelAndView = new ModelAndView("BookInsertJSP");

        modelAndView.addObject("book",bookDTO);
        modelAndView.addObject("types",types);
        modelAndView.addObject("authors",authors);
        modelAndView.addObject("nameAuthorsOfBook",nameAuthorsOfBook);
        modelAndView.addObject("type","edit");
        return modelAndView;
    }

    @PostMapping
    @RequestMapping(value = "/edit")
    public String updateBook(@ModelAttribute("book") BookDTO bookDTO,
                             @Nullable @RequestParam("author") Integer[] idAuthors,
                             @RequestParam("type") Integer idType){
        Set<AuthorDTO> authors = new HashSet<>();
        for (Integer idAuthor:idAuthors) {
            authors.add(authorService.getAuthorById(idAuthor));
        }

        TypeDTO type = typeService.getTypeById(idType);

        bookDTO.setTypebook(type);
        bookService.updateBook(bookDTO.getIdbook(),bookDTO,authors);

        return ("redirect:/book/list");
    }
}
