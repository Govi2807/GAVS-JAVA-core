<!DOCTYPE html>
<html>
<head>
    <title>User Account</title>
    <link rel="stylesheet" type="text/css" href="banking.css">
    
</head>
<body>
    <h1>Welcome, <%= session.getAttribute("userId") %></h1>
    <form action="Withdraw.jsp" method="post">
        <input type="submit" value="Withdraw Money">
    </form>
    <form action="Deposit.jsp" method="post">
        <input type="submit" value="Deposit Money">
    </form>
    <form action="FundTransfer.jsp" method="post">
        <input type="submit" value="Fund Transfer">
    </form>
    <form action="Balance.jsp" method="post">
        <input type="submit" value="Check Balance">
    </form>
    <form action="Logout.jsp" method="post">
        <input type="submit" value="Logout">
    </form>
</body>
</html>
