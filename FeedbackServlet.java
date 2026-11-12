package com.feedback;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.*;
import javax.servlet.http.*;
public class FeedbackServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
                          throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String feedbackType =
                request.getParameter("feedbackType");
        String comments = request.getParameter("comments");
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern(
                    "dd-MM-yyyy HH:mm:ss");
        String dateTime = now.format(formatter);
        out.println("<html>");
        out.println("<head><title>Feedback Result</title></head>");
        out.println("<body>");
        out.println("<h2>Feedback Submitted Successfully!</h2>");
        out.println("<h3>Thank you, " + escape(name)
                    + " for your feedback!</h3>");
        out.println("<p><b>Email:</b> "
                    + escape(email) + "</p>");
        out.println("<p><b>Feedback Type:</b> "
                    + escape(feedbackType) + "</p>");
        out.println("<p><b>Comments:</b> "
                    + escape(comments) + "</p>");
        out.println("<p><b>Date and Time:</b> "
                    + dateTime + "</p>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
    private String escape(String value) {
        if (value == null) return "";
        return value.replace("&", "&amp;")
                    .replace("<", "&lt;")
                    .replace(">", "&gt;")
                    .replace("\"", "&quot;")
                    .replace("'", "&#39;");
    }
}
