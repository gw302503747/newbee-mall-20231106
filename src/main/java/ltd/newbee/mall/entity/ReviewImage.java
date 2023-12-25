package ltd.newbee.mall.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ReviewImage {
	private long goodsId;
	private String skuId;
	private long userId;
	private long reviewId;
	private List<String> imagePath;
	private String reviewImage;

	
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
	
	
	public List<String> getImagePath() {
		return imagePath;
	}
	public void setImagePath(List<String> imagePath) {
		this.imagePath = imagePath;
	}
	public String getReviewImage() {
		return reviewImage;
	}
	public void setReviewImage(String reviewImage) {
		this.reviewImage = reviewImage;
	}
	

}
