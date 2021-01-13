package dao;

import entity.TypeEntity;

import java.util.List;

public interface TypeDao {
    public TypeEntity getTypeById(Integer id);
    public List<TypeEntity> getAllType();
}
