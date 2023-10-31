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

@WebServlet("/WithdrawServlet")
public class WithdrawServlet extends HttpServlet {
    
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double amountToWithdraw = Double.parseDouble(request.getParameter("amount"));

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
            double currentBalance = 0.0;
            
            if (resultSet.next()) {
                currentBalance = resultSet.getDouble("balance");
            }
            
            if (amountToWithdraw > currentBalance) {
                // Withdrawal amount exceeds the current balance
                response.sendRedirect("withdraw.jsp?error=1");
            } else {
                // Update the balance after the withdrawal
                currentBalance -= amountToWithdraw;
                
                // Update the account balance in the database
                String updateQuery = "UPDATE user_accounts SET balance = ? WHERE userId = ?";
                PreparedStatement updateStatement = conn.prepareStatement(updateQuery);
                updateStatement.setDouble(1, currentBalance);
                updateStatement.setString(2, userId);
                
                int rowsUpdated = updateStatement.executeUpdate();
                
                if (rowsUpdated > 0) {
                    // Withdrawal successful, you can redirect to a success page
                    response.sendRedirect("withdrawSuccess.jsp");
                } else {
                    // Handle withdrawal failure
                    response.sendRedirect("withdraw.jsp?error=2");
                }
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
