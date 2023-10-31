package jj;

import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public ProductServlet() {
        super();
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int prodId = Integer.parseInt(request.getParameter("prodId"));
        String prodName = request.getParameter("prodName");
        String prodColor = request.getParameter("prodColor");
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pro", "root", "Google@456");
            System.out.println("Connection Established...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            PreparedStatement s = con.prepareStatement("insert into products(prodId, prodName, prodColor) values(?, ?, ?)");
            s.setInt(1, prodId);
            s.setString(2, prodName);
            s.setString(3, prodColor);
            int x = s.executeUpdate();
            if (x != 0) {
                PrintWriter out = response.getWriter();
                out.println("Record Inserted...");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

   