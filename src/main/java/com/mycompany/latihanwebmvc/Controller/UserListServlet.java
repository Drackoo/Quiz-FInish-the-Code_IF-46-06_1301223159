package com.mycompany.latihanwebmvc.Controller;

import com.mycompany.latihanwebmvc.Database.DBUtil;
import com.mycompany.latihanwebmvc.Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/UserList")
public class UserListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = new ArrayList<>();
        
        
        try (Connection conn = DBUtil.getConnection()) {
            String query = "SELECT * FROM users";
            
            try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
                while (rs.next()) {
                    User user = new User(
                            rs.getInt("id"),
                            rs.getString("username"),
                            rs.getString("password"),
                            rs.getString("full_name")
                    );
                    users.add(user);
                }
            }
            
            
            request.setAttribute("users", users);

            
            request.getRequestDispatcher("/UserList.jsp").forward(request, response);

        } catch (SQLException e) {
            e.printStackTrace();  
            request.setAttribute("errorMessage", "An error occurred while fetching users from the database.");
            request.getRequestDispatcher("/error.jsp").forward(request, response); 
        }
    }
}
