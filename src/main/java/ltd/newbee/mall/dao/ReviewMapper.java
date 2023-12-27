/**
 * 严肃声明：
 * 开源版本请务必保留此注释头信息，若删除我方将保留所有法律责任追究！
 * 本系统已申请软件著作权，受国家版权局知识产权以及国家计算机软件著作权保护！
 * 可正常分享和学习源码，不得用于违法犯罪活动，违者必究！
 * Copyright (c) 2019-2020 十三 all rights reserved.
 * 版权所有，侵权必究！
 */
package ltd.newbee.mall.dao;

import ltd.newbee.mall.entity.QA;
import ltd.newbee.mall.entity.Review;
import ltd.newbee.mall.entity.ReviewImage;
import ltd.newbee.mall.entity.Scores;
import ltd.newbee.mall.entity.SkuImage;
import ltd.newbee.mall.util.PageQueryUtil;

import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

public interface ReviewMapper {
	
	int insertReview(Review review);
	
	int insertReviewImage(ReviewImage reviewImage);
	
	List<Review> findReviewList(PageQueryUtil pageUtil);
	
	int getTotalReviews(PageQueryUtil pageUtil);
	
	List<Long> selectReviewId(@Param("goodsId") Long goodsId, @Param("skuId") String skuId);

	List<String> selectImageByReviewId(Long reviewId);
	
	int selectAverageOfScores(@Param("goodsId") Long goodsId, @Param("skuId") String skuId);
	
	Scores getCountOfScores(@Param("goodsId") Long goodsId, @Param("skuId") String skuId);

}