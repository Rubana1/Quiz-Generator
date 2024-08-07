package com.api;



import Models.Quiz;
import Services.QuizService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/api/createQuiz")
public class CreateQuizServlet extends HttpServlet {
    private QuizService quizService = new QuizService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");

        if (title == null || description == null) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("{ \"message\": \"Title and description are required\" }");
            return;
        }

        Quiz quiz = quizService.createQuiz(title, description);

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.write("{ \"id\": " + quiz.getQuizId() + ", \"title\": \"" + quiz.getTitle() + "\", \"description\": \"" + quiz.getDescription() + "\" }");
        out.flush();
        out.close();
    }
}