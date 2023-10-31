package jj;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/pro";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Google@456";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Authenticate the user (you should use a more secure method)
        if (username.equals("admin") && password.equals("adminpassword")) {
            response.sendRedirect("admin.jsp");
        } else if (username.equals("user") && password.equals("userpassword")) {
            response.sendRedirect("userProduct.jsp");
        } else {
            response.sendRedirect("login.jsp");
        }
    }
}
