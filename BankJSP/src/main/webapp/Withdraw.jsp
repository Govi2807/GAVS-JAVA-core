<!DOCTYPE html>
<html>
<head>
    <title>Withdraw Money</title>
    <link rel="stylesheet" type="text/css" href="banking.css">
    
</head>
<body>
    <h1>Withdraw Money</h1>
    <form action="WithdrawServlet" method="post">
        <label for="amount">Amount to Withdraw:</label>
        <input type="number" name="amount" id="amount" required><br>
        <input type="submit" value="Withdraw">
    </form>
</body>
</html>
