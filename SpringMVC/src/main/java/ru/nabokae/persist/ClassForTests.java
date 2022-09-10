package ru.nabokae.persist;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import ru.nabokae.AppConfig;

public class ClassForTests {
    public static void main(String[] args) {
       /* UserRepository userRepository2 = new UserRepositoryImpl();
        User user1 = new User(1L, "1111", "11111", 16);
        userRepository2.update(user1);

        System.out.println(userRepository2.findById(1));
        userRepository2.delete(1);
        System.out.println(userRepository2.findById(1));*/
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        LocalContainerEntityManagerFactoryBean entityManagerFactory = context.getBean(LocalContainerEntityManagerFactoryBean.class);
        EntityManager entityManager= entityManagerFactory.createNativeEntityManager();
        EntityManager em = entityManagerFactory.
    }
}
