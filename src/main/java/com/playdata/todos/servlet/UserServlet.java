package com.playdata.todos.servlet;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import com.playdata.todos.dao.UserDao;

import com.playdata.todos.dto.User;
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(200);
        req.getRequestDispatcher("views/user.html").forward(req,resp);
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        String name=req.getParameter("name");

        User user= new User(null,username,name,password,null);
        UserDao dao=new UserDao();
        dao.insert(user);
        resp.sendRedirect("/user");
        resp.setStatus(201);

    }
}
