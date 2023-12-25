package ltd.newbee.mall.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Review {
	private long goodsId;
	private String skuId;
	private long userId;
	private long reviewId;
	private long scores;
	private String nickName;
	private String reviewTitle;
	private String reviewContent;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
	private List<String> reviewImages;
	

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
	public long getReviewId() {
		return reviewId;
	}
	public void setReviewId(long reviewId) {
		this.reviewId = reviewId;
	}
	public long getScores() {
		return scores;
	}
	public void setScores(long scores) {
		this.scores = scores;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getReviewTitle() {
		return reviewTitle;
	}
	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}
	public String getReviewContent() {
		return reviewContent;
	}
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public List<String> getReviewImages() {
		return reviewImages;
	}
	public void setReviewImages(List<String> reviewImages) {
		this.reviewImages = reviewImages;
	}
	
	@Override
	public String toString() {
		return "Review [goodsId=" + goodsId + ", skuId=" + skuId + ", userId=" + userId + ", reviewId=" + reviewId
				+ ", scores=" + scores + ", nickName=" + nickName + ", reviewTitle=" + reviewTitle + ", reviewContent="
				+ reviewContent + ", createTime=" + createTime + ", reviewImages=" + reviewImages + "]";
	}
	
}
