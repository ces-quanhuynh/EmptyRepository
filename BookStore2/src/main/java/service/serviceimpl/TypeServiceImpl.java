package service.serviceimpl;

import dao.TypeDao;
import dao.daoimpl.TypeDaoImpl;
import entity.TypeEntity;
import service.TypeService;

import java.util.List;

public class TypeServiceImpl implements TypeService {

    TypeDao typeDao = new TypeDaoImpl();

    @Override
    public TypeEntity getTypeById(Integer id) {
        return typeDao.getTypeById(id);
    }

    @Override
    public List<TypeEntity> getAllType() {
        return typeDao.getAllType();
    }
}
