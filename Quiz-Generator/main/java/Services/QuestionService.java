package Services;

import Models.question;

public class QuestionService {
    public question createQuestion(String questionText, String[] options, int correctOptionIndex) {
        return new question(questionText, options, correctOptionIndex);
    }

    
}
