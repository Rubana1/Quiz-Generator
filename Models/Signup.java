package Models;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Signup extends HttpServlet {
    
    private SignupService signupService = new SignupService();

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        if (signupService.isValidSignup(email, password)) {
            res.getWriter().append("Signup success");
        } else {
            res.getWriter().append("Signup failed");
        }
    }
 
    private static class SignupService {
        
        public boolean isValidSignup(String email, String password) {
            return isValidEmail(email) && isValidPassword(password);
        }

        
        private boolean isValidPassword(String password) {
            
            return password != null && password.length() >= 8 && password.matches(".*\\d.*") && password.matches(".*[!@#$%^&*()\\-+].*");
        }

       
        private boolean isValidEmail(String email) {
           
            return email != null && email.contains("@") && email.contains(".");
        }
    }
}