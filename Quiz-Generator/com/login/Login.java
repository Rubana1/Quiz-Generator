package com.login;


import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Services.LoginService;

public class Login extends HttpServlet {
    
    private LoginService loginService = new LoginService();

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");

        //if (name == null || name.isEmpty()) {
         //   res.getWriter().append("Login failed: Username cannot be empty");
        //    return;
       // }
        
      //  if (!password.contains(".")) {
       //     res.getWriter().append("Login failed: Password must contain '.' symbols");
         //   return;
        //}

        String loginResult = loginService.isValidLogin(name, password);

        if ("Login success".equals(loginResult)) { // Check if loginResult is "Login success"
            res.getWriter().append("Login success");
        } else {
            res.getWriter().append("Login failed: " + loginResult);
        }
    }
    
    

}
