package dao.daoimpl;

import dao.TypeDao;
import entity.TypeEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.List;

public class TypeDaoImpl implements TypeDao {
    @Override
    public TypeEntity getTypeById(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.get(TypeEntity.class,id);
    }

    @Override
    public List<TypeEntity> getAllType() {
        List<TypeEntity> list;
        Session session = HibernateUtil.getSessionFactory().openSession();
        String sql = "select * from test.type";
        Query query = session.createNativeQuery(sql, TypeEntity.class);
        list = query.getResultList();
        return list;
    }
}
