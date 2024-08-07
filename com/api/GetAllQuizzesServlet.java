package com.api;

import Models.Quiz;
import Services.QuizService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/api/getAllQuizzes")
public class GetAllQuizzesServlet extends HttpServlet {
    private QuizService quizService = new QuizService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Quiz> quizzes = quizService.getAllQuizzes();

        System.out.println("Quizzes list: " + quizzes); // Debug statement

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        if (quizzes != null && !quizzes.isEmpty()) {
            out.write("[");
            for (int i = 0; i < quizzes.size(); i++) {
                Quiz quiz = quizzes.get(i);
                out.write("{ \"id\": " + quiz.getQuizId() + ", \"title\": \"" + quiz.getTitle() + "\", \"description\": \"" + quiz.getDescription() + "\" }");
                if (i < quizzes.size() - 1) {
                    out.write(", ");
                }
            }
            out.write("]");
        } else {
            out.write("[]"); // return an empty array if there are no quizzes
        }

        out.flush();
        out.close();
    }
}
