package api;

import Models.Quiz;
import Services.QuizService;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class GetAllQuizzesServlet extends HttpServlet {
    private QuizService quizService = new QuizService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Quiz> quizzes = quizService.getAllQuizzes();

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        StringBuilder json = new StringBuilder("[");
        for (Quiz quiz : quizzes) {
            json.append("{ \"id\": ").append(quiz.getQuizId())
                .append(", \"title\": \"").append(quiz.getTitle())
                .append("\", \"description\": \"").append(quiz.getDescription()).append("\" },");
        }
        if (!quizzes.isEmpty()) {
            json.setLength(json.length() - 1); // Remove last comma
        }
        json.append("]");
        out.write(json.toString());
        out.flush();
        out.close();
    }
}
