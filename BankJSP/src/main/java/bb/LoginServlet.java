package bb;

import java.io.IOException;
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

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");

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

        // Perform user authentication
        boolean authenticationSuccessful = false;
        try {
            String selectQuery = "SELECT * FROM user_accounts WHERE userId = ? AND password = ?";
            PreparedStatement statement = conn.prepareStatement(selectQuery);
            statement.setString(1, userId);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                // Authentication successful
                authenticationSuccessful = true;
            }

            resultSet.close();
            statement.close();
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

        if (authenticationSuccessful) {
            HttpSession session = request.getSession();
            session.setAttribute("userId", userId);
            response.sendRedirect("account.jsp");
        } else {
            // Redirect back to login page with an error message
            response.sendRedirect("login.jsp?error=1");
        }
    }
}
