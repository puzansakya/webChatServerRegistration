/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puzan.webChatServer.Controller;

import com.puzan.webChatServer.DAO.userDAO;
import com.puzan.webChatServer.entities.User;
import com.puzan.webChatServer.impl.UserDAOimpl;
import com.puzan.webChatServer.system.Controller;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author puzan
 */
@WebServlet(name = "register", urlPatterns = {"/", "/register"})
public class registerController extends Controller {

    private userDAO userdao = new UserDAOimpl();

    private String viewpath = "WEB-INF/views/";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(viewpath + "register/index.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        try {
            if ((userdao.getByUsername(username)) != null) {
                response.sendRedirect(request.getContextPath() + "/register?error=1");
            } else {
                if (userdao.insert(user) > 0) {
                    response.sendRedirect(request.getContextPath() + "/register?success=1");
                    //response.getWriter().write("registered");
                }
            }

        } catch (SQLException | ClassNotFoundException ioe) {

        }

    }

}
