package Models;

public class question {
	 private String questionText;
	    private String[] options;
	    private int correctOptionIndex;

	    public question(String questionText, String[] options, int correctOptionIndex) {
	        this.setQuestionText(questionText);
	        this.setOptions(options);
	        this.setCorrectOptionIndex(correctOptionIndex);
	    }

		public String getQuestionText() {
			return questionText;
		}

		public void setQuestionText(String questionText) {
			this.questionText = questionText;
		}

		public String[] getOptions() {
			return options;
		}

		public void setOptions(String[] options) {
			this.options = options;
		}

		public int getCorrectOptionIndex() {
			return correctOptionIndex;
		}

		public void setCorrectOptionIndex(int correctOptionIndex) {
			this.correctOptionIndex = correctOptionIndex;
		}


}
