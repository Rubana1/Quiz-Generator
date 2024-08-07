package com.api;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Services.LoginService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private LoginService loginService = new LoginService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        if (name == null || name.isEmpty() || password == null || password.isEmpty()) {
            request.setAttribute("error", "Username and password are required");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return;
        }
        
        String loginResult = loginService.isValidLogin(name, password);

        if ("Login success".equals(loginResult)) {
            HttpSession session = request.getSession();
            session.setAttribute("username", name);
            response.sendRedirect("http://localhost:8084/Quiz_generatorr/"); // Redirect to the specified path after successful login
        } else {
            request.setAttribute("error", "Login failed: " + loginResult);
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}
