package net.javaguides.registration.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import net.javaguides.registration.model.Customer;

public class Customer_Registration {

    public int registerCustomer(Customer customer) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO courier (user_id, name, email, password, phone) VALUES (?, ?, ?, ?, ?);";

        int result = 0;

        Class.forName("com.mysql.cj.jdbc.Driver"); // Updated driver

        try (Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/courier", "root", "Girish@25");
             PreparedStatement preparedStatement = cn.prepareStatement(INSERT_USERS_SQL)) {

            preparedStatement.setInt(1, customer.getUser_Id());
            preparedStatement.setString(2, customer.getName());
            preparedStatement.setString(3, customer.getEmail());
            preparedStatement.setString(4, customer.getPassword());
            preparedStatement.setLong(5, customer.getPhone()); // Changed to String

            System.out.println(preparedStatement);
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            printSQLException(e);
        }
        return result;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
            }
        }
    }
}
