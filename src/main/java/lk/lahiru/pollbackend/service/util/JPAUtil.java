package lk.lahiru.pollbackend.service.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    private static EntityManagerFactory emf= buildEntityManagerFactory();

    private static EntityManagerFactory buildEntityManagerFactory() {
        return Persistence.createEntityManagerFactory("poll");
    }
    public static  EntityManagerFactory entityManagerFactory(){
        return emf;
    }
}
