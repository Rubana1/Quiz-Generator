package com.api;



import Models.Quiz;
import Services.QuizService;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class GetQuizServlet extends HttpServlet {
    private QuizService quizService;

    @Override
    public void init() throws ServletException {
        super.init();
        // Initialize the QuizService
        quizService = new QuizService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String quizIdParam = request.getParameter("quizId");
        if (quizIdParam == null || quizIdParam.isEmpty()) {
            // No quizId parameter provided
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("{ \"message\": \"Quiz ID is required\" }");
            return;
        }

        try {
            int quizId = Integer.parseInt(quizIdParam);
            Quiz quiz = quizService.getQuizById(quizId);

            if (quiz != null) {
                // Found the quiz, send it as JSON response
                response.setContentType("application/json");
                response.getWriter().write("{ \"id\": " + quiz.getQuizId() + ", \"title\": \"" + quiz.getTitle() + "\", \"description\": \"" + quiz.getDescription() + "\" }");
            } else {
                // Quiz not found
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                response.getWriter().write("{ \"message\": \"Quiz not found\" }");
            }
        } catch (NumberFormatException e) {
            // Invalid quiz ID format
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("{ \"message\": \"Invalid quiz ID format\" }");
        }
    }
}