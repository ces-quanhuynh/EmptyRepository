package service;

import entity.TypeEntity;

import java.util.List;

public interface TypeService {
    public TypeEntity getTypeById(Integer id);
    public List<TypeEntity> getAllType();
}
