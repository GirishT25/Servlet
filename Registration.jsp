<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Customer Registration</title>
</head>
<body>
    <h2>Customer Registration Form</h2>
    <form action="Courier_Registraion" method="post">
        <label for="User_id">User ID:</label>
        <input type="number" id="user_id" name="user_id" required><br><br>

        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br><br>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br><br>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br><br>

        <label for="phone">Phone:</label>
        <input type="number" id="phone" name="phone" required><br><br>

        <button type="submit">Register</button>
    </form>
</body>
</html>
