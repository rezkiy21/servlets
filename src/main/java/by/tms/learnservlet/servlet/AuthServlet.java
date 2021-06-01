package by.tms.learnservlet.servlet;

import by.tms.learnservlet.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/auth")
public class AuthServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String pass = req.getParameter("pass");
        User user = new User();
        user.setLogin(login);
        user.setPassword(pass);
        for (User user1 : ((List<User>) getServletContext().getAttribute("userList"))) {
            if (user1.equals(user)) {
                req.getSession().setAttribute("currentUser", user1);
            }
        }
    }
}
