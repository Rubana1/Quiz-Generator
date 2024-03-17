package models;

public class Option {
	private char label;
	private String text;
	
	public Option(char label, String text) {
		this.setLabel(label);
		this.setText(text);
	}

	public char getLabel() {
		return label;
	}

	public void setLabel(char label) {
		this.label = label;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
