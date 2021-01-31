package com.bookstore.entity;

import javax.persistence.*;

@Entity(name = "type")
public class TypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idType;

    @Column(name = "nametype")
    String nameType;

    public TypeEntity() {
    }

    public TypeEntity(Integer idType, String nameType) {
        this.idType = idType;
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
