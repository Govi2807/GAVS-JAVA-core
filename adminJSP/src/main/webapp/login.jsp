<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
    
</head>
<body>
     <h1>Welcome To Login Page!</h1>
    <form action="LoginServlet" method="post">
        <label for="username">Username: </label>
        <input type="text" name="username" id="username" required><br>

        <label for="password">Password: </label>
        <input type="password" name="password" id="password" required><br>

        <input type="submit" value="Login">
    </form>
</body>
</html>
