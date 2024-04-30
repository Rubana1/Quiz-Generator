package Services;

import Models.answer;
import Models.question;

public class AnswerService {
    public answer createAnswer(question question, String userAnswer) {
        return new answer(question, userAnswer);
    }

    
}