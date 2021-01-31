package com.bookstore.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "book")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idBook;

    @Column(name = "namebook")
    String nameBook;

    @ManyToOne
    @JoinColumn(name = "idtype")
    TypeEntity typeBook;

    @ManyToMany(
            fetch = FetchType.EAGER
    )
    @JoinTable(
            name = "bookauthor",
            joinColumns = @JoinColumn(name = "idbook"),
            inverseJoinColumns = @JoinColumn(name = "idauthor")
    )
    Set<AuthorEntity> authors;

    public BookEntity() {
    }

    public BookEntity(Integer idBook, String nameBook, TypeEntity typeBook, Set<AuthorEntity> authors) {
        this.idBook = idBook;
        this.nameBook = nameBook;
        this.typeBook = typeBook;
        this.authors = authors;
    }

    public Integer getIdBook() {
        return idBook;
    }

    public void setIdBook(Integer idBook) {
        this.idBook = idBook;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public TypeEntity getTypeBook() {
        return typeBook;
    }

    public void setTypeBook(TypeEntity typeBook) {
        this.typeBook = typeBook;
    }

    public Set<AuthorEntity> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<AuthorEntity> authors) {
        this.authors = authors;
    }
}
