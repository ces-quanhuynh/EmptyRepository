package util;

import entity.AuthorEntity;
import entity.BookEntity;
import entity.TypeEntity;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    public static SessionFactory getSessionFactory(){
        try {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
//        configuration.addClass(BookEntity.class);
//        configuration.addClass(AuthorEntity.class);
//        configuration.addClass(TypeEntity.class);
            return configuration.buildSessionFactory();
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
