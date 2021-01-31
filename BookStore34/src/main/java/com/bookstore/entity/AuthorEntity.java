package com.bookstore.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "author")
public class AuthorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idAuthor;

    @Column(name = "nameauthor")
    String nameAuthor;

    @ManyToMany(
            fetch = FetchType.EAGER,
            mappedBy = "authors"
    )
    Set<BookEntity> books;

    public AuthorEntity() {
    }

    public AuthorEntity(Integer idAuthor, String nameAuthor, Set<BookEntity> books) {
        this.idAuthor = idAuthor;
        this.nameAuthor = nameAuthor;
        this.books = books;
    }

    public Integer getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(Integer idAuthor) {
        this.idAuthor = idAuthor;
    }

    public String getNameAuthor() {
        return nameAuthor;
    }

    public void setNameAuthor(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }

    public Set<BookEntity> getBooks() {
        return books;
    }

    public void setBooks(Set<BookEntity> books) {
        this.books = books;
    }
}
