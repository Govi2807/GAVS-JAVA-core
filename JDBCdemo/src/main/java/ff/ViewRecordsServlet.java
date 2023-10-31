package ff;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession; 

@WebServlet("/ViewRecordsServlet")
public class ViewRecordsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ViewRecordsServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>Record Listing</h1>");

        // Retrieve the timestamp of the last visit from the session or a cookie
        HttpSession session = request.getSession();
        long lastVisitTimestamp = (Long) session.getAttribute("lastVisitTimestamp");

        try {
            PreparedStatement s = con.prepareStatement("SELECT pid, pname, color, timestamp FROM parts WHERE timestamp > ?");
            s.setLong(1, lastVisitTimestamp);
            ResultSet rs = s.executeQuery();
            out.println("<table border='1'><tr><th>Part ID</th><th>Part Name</th><th>Color</th></tr>");
            while (rs.next()) {
                int pid = rs.getInt("pid");
                String partname = rs.getString("pname");
                String color = rs.getString("color");
                long timestamp = rs.getLong("timestamp");
                out.println("<tr><td>" + pid + "</td><td>" + partname + "</td><td>" + color + "</td></tr>");
                // Update the timestamp of the last visit to the most recent record
                if (timestamp > lastVisitTimestamp) {
                    lastVisitTimestamp = timestamp;
                }
            }
            out.println("</table>");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Store the updated timestamp in the session
        session.setAttribute("lastVisitTimestamp", lastVisitTimestamp);
    }
}
