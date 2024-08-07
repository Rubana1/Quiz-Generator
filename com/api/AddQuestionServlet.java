package com.api;


import Models.Question;
import Services.QuizService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/api/addQuestion")
public class AddQuestionServlet extends HttpServlet {
    private QuizService quizService = new QuizService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String quizIdParam = request.getParameter("quizId");
        String text = request.getParameter("text");
        String correctAnswer = request.getParameter("correctAnswer");
        String[] options = request.getParameterValues("options");

        if (quizIdParam == null || text == null || correctAnswer == null || options == null) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("{ \"message\": \"All fields are required\" }");
            return;
        }

        try {
            int quizId = Integer.parseInt(quizIdParam);
            Question question = quizService.addQuestionToQuiz(quizId, text, correctAnswer, options);

            response.setContentType("application/json");
            PrintWriter out = response.getWriter();
            out.write("{ \"id\": " + question.getId() + ", \"quizId\": " + question.getQuizId() + ", \"text\": \"" + question.getText() + "\", \"correctAnswer\": \"" + question.getCorrectAnswer() + "\", \"options\": \"" + String.join(",", question.getOptions()) + "\" }");
            out.flush();
            out.close();
        } catch (NumberFormatException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("{ \"message\": \"Invalid quiz ID format\" }");
        }
    }
}
