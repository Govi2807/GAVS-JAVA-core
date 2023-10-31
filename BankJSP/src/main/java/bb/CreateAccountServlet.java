package bb;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CreateAccountServlet")
public class CreateAccountServlet extends HttpServlet {
    
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");
        // Other account details
        
        // JDBC Database Connection
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/bank"; // Update with your database URL
            String dbUser = "root"; // Update with your database username
            String dbPassword = "Google@456"; // Update with your database password
            conn = DriverManager.getConnection(url, dbUser, dbPassword);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        // Insert the user's account details into the database
        try {
            String insertQuery = "INSERT INTO user_accounts (userId, password) VALUES (?, ?)";
            PreparedStatement statement = conn.prepareStatement(insertQuery);
            statement.setString(1, userId);
            statement.setString(2, password);
            // Set other account details
            // statement.setString(3, otherValue);
            // ...
            int rowsInserted = statement.executeUpdate();
            
            if (rowsInserted > 0) {
                // Redirect to a confirmation page
                response.sendRedirect("accountCreated.jsp");
            } else {
                // Handle insertion failure
                response.sendRedirect("createAccount.jsp?error=1");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}


