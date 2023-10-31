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
 
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public DeleteServlet() {
        super();
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pidToDelete = Integer.parseInt(request.getParameter("deletePartID"));
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
            PreparedStatement s = con.prepareStatement("DELETE FROM parts WHERE pid = ?");
            s.setInt(1, pidToDelete);
            int rowsDeleted = s.executeUpdate();
            if (rowsDeleted > 0) {
                PrintWriter out = response.getWriter();
                out.println("Record with PID " + pidToDelete + " deleted.");
            } else {
                PrintWriter out = response.getWriter();
                out.println("Record with PID " + pidToDelete + " not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}