package Services;

import models.Quiz;

public class QuizService {
	public Quiz generatorQuizByTiltle(String title) {
		return new Quiz(title);
	}
	
	public Quiz generateCustomQuiz(String[] titles) {
		return new Quiz("custom quiz");
	}

}
