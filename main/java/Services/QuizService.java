package Services;

import Models.question;
import Models.quiz;

public class QuizService {
    private Models.quiz quiz;

    public QuizService() {
        this.quiz = new Models.quiz();
    }

    public void addQuestionToQuiz(question question) {
        quiz.addQuestion(question);
    }

    public Quiz getQuiz() {
        return quiz;
    }

    
}
