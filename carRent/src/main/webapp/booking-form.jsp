<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Car Booking Form</title>
</head>
<body>
    <h1>Car Booking Form</h1>

    <form action="/book" method="post">
        <label for="carId">Select a Car:</label>
        <select name="carId" id="carId">
            <!-- Iterate through a list of available cars obtained from the controller -->
            <c:forEach items="${cars}" var="car">
                <option value="${car.id}">${car.vehicleName}</option>
            </c:forEach>
        </select>
        <br>

        <label for="bookingDate">Booking Date:</label>
        <input type="date" name="bookingDate" id="bookingDate">
        <br>

        <label for="distanceTraveled">Distance Traveled (in km):</label>
        <input type="text" name="distanceTraveled" id="distanceTraveled">
        <br>

        <input type="submit" value="Book Car">
    </form>
</body>
</html>
