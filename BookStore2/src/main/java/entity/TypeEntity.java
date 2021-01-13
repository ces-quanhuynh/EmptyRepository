package entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "type")
public class TypeEntity implements Serializable {

    private static final long serialVersionUID = 7706707498325744746L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idType;

    @Column(name = "nametype", nullable = false)
    String nameType;

    public TypeEntity() {
    }

    public TypeEntity(String nameType) {
        this.nameType = nameType;
    }

    public Integer getIdType() {
        return idType;
    }

    public void setIdType(Integer idType) {
        this.idType = idType;
    }

    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }
}
