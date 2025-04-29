package com.cg;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/page1")
public class Page1Servlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        Cookie cookie1 = new Cookie("firstName", firstName);
        Cookie cookie2 = new Cookie("lastName", lastName);

        response.addCookie(cookie1);
        response.addCookie(cookie2);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>Page 2 - Enter Email and Phone</h2>");
        out.println("First Name: " + firstName + "<br>");
        out.println("Last Name: " + lastName + "<br><br>");
        out.println("<form action='page2' method='post'>");
        out.println("Email: <input type='text' name='email'><br><br>");
        out.println("Phone: <input type='text' name='phone'><br><br>");
        out.println("<input type='submit' value='Next'>");
        out.println("</form>");
        out.println("</body></html>");
    }
}