<!DOCTYPE html>
<html>
<head>
    <title>Balance Checked</title>
    <link rel="stylesheet" type="text/css" href="banking.css">
    
</head>
<body>
    <h1>Balance Checked</h1>
    <p>Your current account balance is: <%= session.getAttribute("balance") %></p>
    <p><a href="account.jsp">Back to Account Page</a></p>
</body>
</html>
