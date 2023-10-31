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

@WebServlet("/BalanceServlet")
public class BalanceServlet extends HttpServlet {
    
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/bank"; // Update with your database URL
            String dbUser = "root"; // Update with your database username
            String dbPassword = "Google@456"; // Update with your database password
            conn = DriverManager.getConnection(url, dbUser, dbPassword);
            
            HttpSession session = request.getSession();
            String userId = (String) session.getAttribute("userId");
            
            // Retrieve the current balance
            String selectQuery = "SELECT balance FROM user_accounts WHERE userId = ?";
            PreparedStatement selectStatement = conn.prepareStatement(selectQuery);
            selectStatement.setString(1, userId);
            
            ResultSet resultSet = selectStatement.executeQuery();
            
            if (resultSet.next()) {
                double currentBalance = resultSet.getDouble("balance");
                session.setAttribute("balance", currentBalance);
                response.sendRedirect("balanceChecked.jsp");
            } else {
                // Handle balance retrieval failure
                response.sendRedirect("balance.jsp?error=1");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
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
