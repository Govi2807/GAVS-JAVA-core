package ff;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AddServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pid = Integer.parseInt(request.getParameter("partid"));
        String partname = request.getParameter("partname");
        String color = request.getParameter("color");
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supply", "root", "Google@456");
            System.out.println("Connection Established...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            PreparedStatement s = con.prepareStatement("insert into parts(pid, pname, color) values(?, ?, ?)");
            s.setInt(1, pid);
            s.setString(2, partname);
            s.setString(3, color);
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


