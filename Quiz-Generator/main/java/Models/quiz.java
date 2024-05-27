package Models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class quiz {
	private List<question> questions;

    public quiz() {
        this.questions = new ArrayList<>();
    }

    public void addQuestion(question question) {
        questions.add(question);
    }

    public List<question> getQuestions() {
        return questions;
    }

    public void shuffleQuestions() {
        Collections.shuffle(questions);
    }


}
