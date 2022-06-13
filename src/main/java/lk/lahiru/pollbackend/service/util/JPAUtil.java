package lk.lahiru.pollbackend.service.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.util.Properties;

public abstract class JPAUtil {

    private static final EntityManagerFactory emf = buildEntityManagerFactory();

    private static EntityManagerFactory buildEntityManagerFactory() {
        Properties prop = new Properties();
        try {
            String profile = System.getProperty("app.profiles.active", "test");
            prop.load(JPAUtil.class.getResourceAsStream(
                    profile.equals("test") ? "/application-test.properties" : "/application.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return Persistence.createEntityManagerFactory("poll", prop);
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }

}
