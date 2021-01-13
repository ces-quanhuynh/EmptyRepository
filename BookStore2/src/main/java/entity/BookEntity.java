package entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "book")
public class BookEntity implements Serializable {

    private static final long serialVersionUID = 4156217024207012687L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idBook;

    @Column(name = "namebook", nullable = false)
    String nameBook;

    @ManyToOne
    @JoinColumn(name = "idauthor")
    AuthorEntity authorBook;

    @ManyToOne
    @JoinColumn(name = "idtype")
    TypeEntity typeBook;


    public BookEntity() {
    }

    public BookEntity(String nameBook, AuthorEntity authorBook, TypeEntity typeBook) {
        this.nameBook = nameBook;
        this.authorBook = authorBook;
        this.typeBook = typeBook;
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

    public AuthorEntity getAuthorBook() {
        return authorBook;
    }

    public void setAuthorBook(AuthorEntity authorBook) {
        this.authorBook = authorBook;
    }

    public TypeEntity getTypeBook() {
        return typeBook;
    }

    public void setTypeBook(TypeEntity typeBook) {
        this.typeBook = typeBook;
    }
}
