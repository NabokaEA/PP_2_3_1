package ru.nabokae;

import ru.nabokae.persist.User;
import ru.nabokae.persist.UserRepository;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class BootstrapListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContextListener.super.contextInitialized(sce);
        ServletContext servletContext = sce.getServletContext();
        UserRepository userRepository = new UserRepository();
        userRepository.save(new User(1L,"Иван","111"));
        userRepository.save(new User(2L,"Марья","222"));
        userRepository.save(new User(3L,"Галя","333"));
        servletContext.setAttribute("userRepository", userRepository);
    }
}

