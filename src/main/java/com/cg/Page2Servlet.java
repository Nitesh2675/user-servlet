package com.cg;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/page2")
public class Page2Servlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        Cookie cookie1 = new Cookie("email", email);
        Cookie cookie2 = new Cookie("phone", phone);

        String firstName = "";
        String lastName = "";

        response.addCookie(cookie1);
        response.addCookie(cookie2);

        // Read cookies
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("firstName")) {
                    firstName = c.getValue();
                }
                if (c.getName().equals("lastName")) {
                    lastName = c.getValue();
                }
            }
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>Page 3 - Enter City and Country</h2>");
        out.println("First Name: " + firstName + "<br>");
        out.println("Last Name: " + lastName + "<br>");
        out.println("Email: " + email + "<br>");
        out.println("Phone: " + phone + "<br><br>");
        out.println("<form action='page3' method='post'>");
        out.println("City: <input type='text' name='city'><br><br>");
        out.println("Country: <input type='text' name='country'><br><br>");
        out.println("<input type='submit' value='Finish'>");
        out.println("</form>");
        out.println("</body></html>");
    }
}