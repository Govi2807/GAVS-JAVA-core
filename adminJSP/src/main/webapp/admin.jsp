<!DOCTYPE html>
<html>
<head>
    <title>Admin Page</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
    
</head>
<body>
    <h1>Welcome, Admin!</h1>
    <form action="ProductServlet" method="post">
        <label for="prodId">Product ID: </label>
        <input type="text" name="prodId" id="prodId" required><br>

        <label for="prodName">Product Name: </label>
        <input type="text" name="prodName" id="prodName" required><br>

        <label for="prodColor">Product Color: </label>
        <input type="text" name="prodColor" id="prodColor" required><br>

        <input type="submit" value="Insert Product">
    </form>

    <form action="product.jsp">
        <input type="submit" value="View Records">
    </form>
</body>
</html>
