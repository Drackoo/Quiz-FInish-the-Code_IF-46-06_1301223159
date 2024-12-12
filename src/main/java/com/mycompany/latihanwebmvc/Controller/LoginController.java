package com.mycompany.latihanwebmvc.Controller;

import com.mycompany.latihanwebmvc.Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {

    /**
     * Proses login pengguna.
     *
     * @param request  HTTP request yang diterima.
     * @param response HTTP response yang dikirimkan.
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        
        User user = new User(username, password, "");

        
        if (user.isValidUser()) {
            
            HttpSession session = request.getSession();
            session.setAttribute("user", user); 
            response.sendRedirect("welcome.jsp");
        } else {
            
            request.setAttribute("errorMessage", "Username atau password Anda salah!");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}
