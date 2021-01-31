package com.bookstore.dto;

import java.util.Set;

public class BookDTO {

    Integer idbook;
    String namebook;
    TypeDTO typebook;
    Set<AuthorDTO> authors;

    public BookDTO() {
    }

    public Integer getIdbook() {
        return idbook;
    }

    public void setIdbook(Integer idbook) {
        this.idbook = idbook;
    }

    public String getNamebook() {
        return namebook;
    }

    public void setNamebook(String namebook) {
        this.namebook = namebook;
    }

    public TypeDTO getTypebook() {
        return typebook;
    }

    public void setTypebook(TypeDTO typebook) {
        this.typebook = typebook;
    }

    public Set<AuthorDTO> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<AuthorDTO> authors) {
        this.authors = authors;
    }
}
