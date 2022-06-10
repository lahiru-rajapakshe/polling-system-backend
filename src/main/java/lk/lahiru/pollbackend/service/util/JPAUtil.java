package lk.lahiru.pollbackend.service.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.util.Properties;

public abstract class JPAUtil {

    private static EntityManagerFactory emf = buildEntityManagerFactory();

    private static EntityManagerFactory buildEntityManagerFactory() {
        Properties prop = new Properties();
        try {
            prop.load(JPAUtil.class.getResourceAsStream("/application-test.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return Persistence.createEntityManagerFactory("poll", prop);
    }

    public static EntityManagerFactory getEntityManagerFactory(){
        return emf;
    }

}

