package ru.nabokae;

import ru.nabokae.persist.User;
import ru.nabokae.persist.UserRepository;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/users")
public class UsersServlet extends HttpServlet {

    private UserRepository userRepository;

    @Override
    public void init() throws ServletException {
        userRepository=(UserRepository) getServletContext().getAttribute("userRepository");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        List<User> userList = userRepository.findAll();
        User user = userList.get(1);
        resp.getWriter().println(user);
        req.getContextPath();
        resp .getWriter().println("<p> ContextPath:"+req.getContextPath());
        resp .getWriter().println("<p> ServletPath:"+req.getServletPath());
        resp .getWriter().println("<p> PathInfo:"+req.getPathInfo());
        resp .getWriter().println("<p> QueryString:"+req.getQueryString());
        resp .getWriter().println("<p> param1:"+req.getParameter("param1"));
        resp .getWriter().println("<p> param2:"+req.getParameter("param2"));
    }
}
