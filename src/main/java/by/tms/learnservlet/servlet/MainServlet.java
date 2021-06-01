package by.tms.learnservlet.servlet;

import by.tms.learnservlet.entity.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/")
public class MainServlet extends HttpServlet {
    //    @Override
//    public void init() throws ServletException {
//        System.out.println("INIT");
//    }
//
//    @Override
//    public void destroy() {
//        System.out.println("destroy");
//    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if (req.getSession().getAttribute("currentUser") == null) {
            resp.getWriter().println("Hello Guest");
        } else {
            User currentUser = (User) req.getSession().getAttribute("currentUser");
            resp.getWriter().println("Hello " + currentUser.getName());
        }
    }
}
