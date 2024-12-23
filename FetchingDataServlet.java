package addition;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/addition")
public class addition extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public addition() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set CORS headers
        response.setHeader("Access-Control-Allow-Origin", "*"); // Allows requests from any origin
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE"); // Allowed HTTP methods
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization"); // Allowed request headers

        // Set response content type
        response.setContentType("text/html");

        try (PrintWriter out = response.getWriter()) {
            // Retrieve numbers from request parameters
            String number1 = request.getParameter("number1");
            String number2 = request.getParameter("number2");

            // Validate and parse input
            int num1 = Integer.parseInt(number1);
            int num2 = Integer.parseInt(number2);

            // Perform addition
            int sum = num1 + num2;

            // Display result
            out.println("<html><body>");
            out.println("<h1>Addition Result</h1>");
            out.println("<p>Number 1: " + num1 + "</p>");
            out.println("<p>Number 2: " + num2 + "</p>");
            out.println("<p>Sum: " + sum + "</p>");
            out.println("</body></html>");
        } catch (NumberFormatException e) {
            response.getWriter().println("<html><body><h1>Error: Invalid input. Please enter valid numbers.</h1></body></html>");
        }
    }

    @Override
    protected void doOptions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle preflight CORS requests
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
        response.setStatus(HttpServletResponse.SC_OK);
    }
}
