<!DOCTYPE html>
<html>
<head>
    <title>Deposit Money</title>
    <link rel="stylesheet" type="text/css" href="banking.css">
    
</head>
<body>
    <h1>Deposit Money</h1>
    <form action="DepositServlet" method="post">
        <label for="amount">Amount to Deposit:</label>
        <input type="number" name="amount" id="amount" required><br>
        <input type="submit" value="Deposit">
    </form>
</body>
</html>
