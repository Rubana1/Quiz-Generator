package models;

import java.util.ArrayList;
import java.util.List;

public class Quiz {
	private String title;
	private List<Question> questions;
	
	public Quiz(String title) {
		this.setTitle(title);
		this.questions = new ArrayList<>();	
	}
	
	public void addQuestion(Question question) {
		questions.add(question);
	}
	
	public void removeQuestion(Question question) {
		questions.remove(question);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
