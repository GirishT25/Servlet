package net.javaguides.registration.controller;

import java.io.IOException;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.javaguides.registration.model.Customer;

@WebServlet("/Courier_Registraion")
public class Courier_Registraion extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Courier_Registraion() {
        super();
    }

    // Handling GET requests - Display the registration form
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Forward the request to the registration page

    }

    // Handling POST requests - Register the customer
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get form data
        try {
            int id = Integer.parseInt(request.getParameter("User_id"));
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            int phone = Integer.parseInt(request.getParameter("phone"));

            // Creating Customer object
            Customer cu = new Customer();
            cu.setUser_Id(id);
            cu.setName(name);
            cu.setEmail(email);
            cu.setPassword(password);
            cu.setPhone(phone);

            // Register customer in the database (you can implement this logic)
            // Example: Customer_Registration.registerCustomer(cu);
            request.setAttribute("message", "Customer registered successfully!");

        } catch (Exception e) {
            // In case of error, set the error message
            request.setAttribute("error", "Error: " + e.getMessage());
        }

        // Forwarding the request back to the registration page (with message)
 
    }
}
