<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.Connection, java.sql.DriverManager, java.sql.PreparedStatement, java.sql.ResultSet, java.sql.SQLException, java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="jj.Product" %> <!-- Import your Product class package -->

<!DOCTYPE html>
<html>
<head>
    <title>Product Page</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
    
</head>
<body>
    <h1>Welcome, Admin!</h1>
    <table border="1">
        <tr>
            <th>Product ID</th>
            <th>Product Name</th>
            <th>Product Color</th>
        </tr>
        <!-- Display product records from the database here -->
        <%
            List<Product> products = new ArrayList<>(); // Create a list to store product records

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                String DB_URL = "jdbc:mysql://localhost:3306/pro";
                String DB_USER = "root";
                String DB_PASSWORD = "Google@456";
                Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                String selectQuery = "SELECT prodId, prodName, prodColor FROM products";
                PreparedStatement stmt = conn.prepareStatement(selectQuery);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    int prodId = rs.getInt("prodId");
                    String prodName = rs.getString("prodName");
                    String prodColor = rs.getString("prodColor");
                    products.add(new Product(prodId, prodName, prodColor));
                }

                rs.close();
                stmt.close();
                conn.close();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            for (Product product : products) {
        %>
        <tr>
            <td><%= product.getProdId() %></td>
            <td><%= product.getProdName() %></td>
            <td><%= product.getProdColor() %></td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>
