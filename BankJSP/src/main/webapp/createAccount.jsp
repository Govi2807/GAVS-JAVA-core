<!DOCTYPE html>
<html>
<head>
    <title>Create Bank Account</title>
    <link rel="stylesheet" type="text/css" href="banking.css">
    
</head>
<body>
    <h1>Create Bank Account</h1>
    <form action="CreateAccountServlet" method="post">
        <label for="userId">User ID:</label>
        <input type="text" name="userId" id="userId" required><br>
        
        <label for="password">Password:</label>
        <input type="password" name="password" id="password" required><br>
        
        <!-- Add additional account details fields as needed -->
        
        <input type="submit" value="Create Account">
    </form>
</body>
</html>
