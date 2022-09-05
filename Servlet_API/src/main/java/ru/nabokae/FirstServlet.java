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

@WebServlet(urlPatterns = "/serv1")
public class FirstServlet extends HttpServlet {

    private ServletConfig servletConfig;
    private UserRepository userRepository;

    @Override
    public void init() throws ServletException {
        userRepository=(UserRepository) getServletContext().getAttribute("userRepository");
    }

    @Override
    public ServletConfig getServletConfig() {
        return servletConfig;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.setContentType("text/html");
        servletResponse.setCharacterEncoding("UTF-8");
        servletResponse.getWriter().println("<h1> Ответ от сервлета serv1</h1>");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        List<User> userList = userRepository.findAll();
        User user = userList.get(1);
        resp.getWriter().println(user);
    }
}
