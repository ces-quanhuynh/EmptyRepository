package entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "author")
public class AuthorEntity implements Serializable {

    private static final long serialVersionUID = -2748734470449180445L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idAuthor;

    @Column(name = "nameauthor", nullable = false)
    String nameAuthor;

    public AuthorEntity(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }

    public AuthorEntity() {

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
}
