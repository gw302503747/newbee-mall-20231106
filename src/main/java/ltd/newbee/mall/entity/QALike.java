package ltd.newbee.mall.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class QALike {
	private long questionId;
	private long likes;
	

	public long getQuestionId() {
		return questionId;
	}
	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}
	
	public long getLikes() {
		return likes;
	}
	public void setLikes(long likes) {
		this.likes = likes;
	}
	
	@Override
	public String toString() {
		return "QALike [questionId=" + questionId + ", likes=" + likes + "]";
	}
	
	
}
