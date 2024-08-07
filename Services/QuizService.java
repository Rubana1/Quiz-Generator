package Services;

import Models.Question;
import Models.Quiz;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuizService {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/quiz";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "root";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }

    public Quiz createQuiz(String title, String description) {
        String query = "INSERT INTO quizzes (title, description) VALUES (?, ?)";
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setDescription(description);

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, title);
            preparedStatement.setString(2, description);
            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                quiz.setQuizId(generatedKeys.getInt(1)); // Set the generated quiz ID
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return quiz;
    }

    public Question addQuestionToQuiz(int quizId, String text, String correctAnswer, String[] options) {
        String query = "INSERT INTO questions (quizId, text, correctAnswer, options) VALUES (?, ?, ?, ?)";
        Question question = new Question();
        question.setQuizId(quizId);
        question.setText(text);
        question.setCorrectAnswer(correctAnswer);
        question.setOptions(options);

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setInt(1, quizId);
            preparedStatement.setString(2, text);
            preparedStatement.setString(3, correctAnswer);
            preparedStatement.setString(4, String.join(",", options));
            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                question.setId(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return question;
    }

    public List<Question> getQuestionsByQuizId(int quizId) {
        List<Question> questions = new ArrayList<>();
        String query = "SELECT * FROM questions WHERE quizId = ?";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, quizId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Question question = new Question();
                question.setId(resultSet.getInt("id"));
                question.setQuizId(resultSet.getInt("quizId"));
                question.setText(resultSet.getString("text"));
                question.setCorrectAnswer(resultSet.getString("correctAnswer"));
                String[] options = resultSet.getString("options").split(",");
                question.setOptions(options);
                questions.add(question);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return questions;
    }

    public Quiz getQuizById(int quizId) {
        String query = "SELECT * FROM quizzes WHERE id = ?";
        Quiz quiz = null;

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, quizId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                quiz = new Quiz();
                quiz.setQuizId(resultSet.getInt("id"));
                quiz.setTitle(resultSet.getString("title"));
                quiz.setDescription(resultSet.getString("description"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return quiz;
    }

    public List<Quiz> getAllQuizzes() {
        List<Quiz> quizzes = new ArrayList<>();
        String query = "SELECT * FROM quizzes";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Quiz quiz = new Quiz();
                quiz.setQuizId(resultSet.getInt("id"));
                quiz.setTitle(resultSet.getString("title"));
                quiz.setDescription(resultSet.getString("description"));
                quizzes.add(quiz);
            }
            System.out.println("Fetched " + quizzes.size() + " quizzes from the database.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return quizzes;
    }
}
