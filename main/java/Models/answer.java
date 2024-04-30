package Models;

public class answer {
	private Models.question question;
    private String userAnswer;

    public answer(Models.question question, String userAnswer) {
        this.setQuestion(question);
        this.setUserAnswer(userAnswer);
    }

	public Models.question getQuestion() {
		return question;
	}

	public void setQuestion(Models.question question) {
		this.question = question;
	}

	public String getUserAnswer() {
		return userAnswer;
	}

	public void setUserAnswer(String userAnswer) {
		this.userAnswer = userAnswer;
	}

}
