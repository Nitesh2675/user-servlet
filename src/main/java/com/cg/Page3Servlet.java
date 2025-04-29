package com.cg;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/page3")
public class Page3Servlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String city = request.getParameter("city");
        String country = request.getParameter("country");

        String firstName = "";
        String lastName = "";
        String phone = "";
        String email = "";

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("firstName")) {
                    firstName = c.getValue();
                }
                if (c.getName().equals("lastName")) {
                    lastName = c.getValue();
                }
                if (c.getName().equals("email")) {
                    email = c.getValue();
                }
                if (c.getName().equals("phone")) {
                    phone = c.getValue();
                }
            }
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>Final Page - All Information</h2>");
        out.println("First Name: " + firstName + "<br>");
        out.println("Last Name: " + lastName + "<br>");
        out.println("Email: " + email + "<br>");
        out.println("Phone: " + phone + "<br>");
        out.println("City: " + city + "<br>");
        out.println("Country: " + country + "<br>");
        out.println("</body></html>");
    }
}