package ltd.newbee.mall.entity;

public class Question {
	private long questionId;
	private long answerId;
	private String answerContext;

	public long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}
	
	public long getAnswerId() {
		return answerId;
	}
	
	public void setAnswerId(long answerId) {
		this.answerId = answerId;
	}

	public String getAnswerContext() {
		return answerContext;
	}

	public void setAnswerContext(String answerContext) {
		this.answerContext = answerContext;
	}
	
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("questionId =").append(questionId);
        sb.append(", answerId=").append(answerId);
        sb.append(", answerContext").append(answerContext);
        sb.append("]");
        return sb.toString();
    }
	
}
