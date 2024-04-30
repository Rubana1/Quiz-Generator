package models;

import java.lang.foreign.Linker.Option;

public class Question {
	private String text;
	private Option[] options;
	private int correctOptionIndex;
	
	public Question(String text, Option[] options, int correctOptionIndex) {
		this.setText(text);
		this.setOptions(options);
		this.setCorrectOptionIndex(correctOptionIndex);
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Option[] getOptions() {
		return options;
	}

	public void setOptions(Option[] options) {
		this.options = options;
	}

	public int getCorrectOptionIndex() {
		return correctOptionIndex;
	}

	public void setCorrectOptionIndex(int correctOptionIndex) {
		this.correctOptionIndex = correctOptionIndex;
	}
	

}
