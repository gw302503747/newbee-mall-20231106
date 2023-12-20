package ltd.newbee.mall.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class QA {
	private long goodsId;
	private String skuId;
	private long userId;
	private long questionId;
	private String questionContent;
	private String answerContent;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
	
	
	public long getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(long goodsId) {
		this.goodsId = goodsId;
	}
	public String getSkuId() {
		return skuId;
	}
	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getQuestionId() {
		return questionId;
	}
	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}
	public String getQuestionContent() {
		return questionContent;
	}
	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}
	public String getAnswerContent() {
		return answerContent;
	}
	public void setAnswerContent(String answerContent) {
		this.answerContent = answerContent;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "QA [goodsId=" + goodsId + ", skuId=" + skuId + ", userId=" + userId + ", questionId=" + questionId
				+ ", questionContent=" + questionContent + ", answerContent=" + answerContent + ", createTime="
				+ createTime + "]";
	}
	
}
