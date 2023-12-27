/**
 * 严肃声明：
 * 开源版本请务必保留此注释头信息，若删除我方将保留所有法律责任追究！
 * 本系统已申请软件著作权，受国家版权局知识产权以及国家计算机软件著作权保护！
 * 可正常分享和学习源码，不得用于违法犯罪活动，违者必究！
 * Copyright (c) 2019-2020 十三 all rights reserved.
 * 版权所有，侵权必究！
 */
package ltd.newbee.mall.controller.mall;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import ltd.newbee.mall.common.Constants;
import ltd.newbee.mall.common.NewBeeMallException;
import ltd.newbee.mall.common.ServiceResultEnum;
import ltd.newbee.mall.controller.vo.NewBeeMallGoodsDetailVO;
import ltd.newbee.mall.controller.vo.NewBeeMallUserVO;
import ltd.newbee.mall.controller.vo.SearchPageCategoryVO;
import ltd.newbee.mall.entity.NewBeeMallGoods;
import ltd.newbee.mall.entity.QA;
import ltd.newbee.mall.entity.Review;
import ltd.newbee.mall.entity.ReviewImage;
import ltd.newbee.mall.entity.Scores;
import ltd.newbee.mall.entity.SkuImage;
import ltd.newbee.mall.service.QAService;
import ltd.newbee.mall.service.ReviewService;
import ltd.newbee.mall.util.PageQueryUtil;
import ltd.newbee.mall.util.PageResult;
import ltd.newbee.mall.util.Result;
import ltd.newbee.mall.util.ResultGenerator;

@Controller
public class ReviewController {

    @Resource
    private ReviewService reviewService;

    
    @RequestMapping(value = "/review/save", method = RequestMethod.POST,consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    @ResponseBody
    public Result save(@RequestParam("goodsId") Long goodsId,
            @RequestParam("skuId") String skuId,
            @RequestParam("userId") Long userId,
            @RequestParam("reviewId") Long reviewId,
            @RequestParam("scores") Long scores,
            @RequestParam("nickName") String nickName,
            @RequestParam("reviewTitle") String reviewTitle,
            @RequestParam("reviewContent") String reviewContent,
            @RequestParam("images") MultipartFile[] images) {
    	
    	// 保存 Image 对象到 image 表
        ReviewImage reviewImage = new ReviewImage();
    	
        int i = 0;
    	    // 处理每个图片
        for (MultipartFile image : images) {
        	
            // 处理文件上传逻辑，保存文件等
            String fileName = image.getOriginalFilename();
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            //生成文件名称通用方法
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
            Random r = new Random();
            StringBuilder tempName = new StringBuilder();
            tempName.append(sdf.format(new Date())).append(r.nextInt(100)).append(suffixName);
            String newFileName = tempName.toString();
            String imagePath = "/Users/wengao/Desktop/newbee-mall-20231106/src/main/resources/upload/" + newFileName;
            
            //保存文件
            reviewImage.setReviewImage(imagePath);
            reviewImage.setGoodsId(goodsId);
            reviewImage.setSkuId(skuId);
            reviewImage.setUserId(userId);
            reviewImage.setReviewId(reviewId);
            reviewService.saveReviewImage(reviewImage);
            
            i++;
            if(i>5) {
            	return ResultGenerator.genFailResult("最多上传5张图片");
            }
        }
        
        Review review = new Review();
        review.setGoodsId(goodsId);
        review.setSkuId(skuId);
        review.setUserId(userId);
        review.setReviewId(reviewId);
        review.setScores(scores);
        review.setNickName(nickName);
        review.setReviewTitle(reviewTitle);
        review.setReviewContent(reviewContent);
        reviewService.saveReview(review);

    	return ResultGenerator.genSuccessResult("评论上传成功");
    }
    
    @RequestMapping(value = "/review/list", method = RequestMethod.GET)
    @ResponseBody
    public Result list(@RequestParam Map<String, Object> params) {
        if (ObjectUtils.isEmpty(params.get("page")) || ObjectUtils.isEmpty(params.get("limit"))) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        PageQueryUtil pageUtil = new PageQueryUtil(params);
        PageResult pageResult = reviewService.getReviewList(pageUtil);
        
        Long goodsId = Long.valueOf(params.get("goodsId").toString());
        String skuId = params.get("skuId").toString();
        List<ReviewImage> imageList=reviewService.getReviewImage(goodsId, skuId);
        
     // 将 reviewImages 插入到 review 中
        if (pageResult.getList() != null && !pageResult.getList().isEmpty()) {
            List<Review> reviewList = (List<Review>) pageResult.getList();

            for (Review review : reviewList) {
                List<String> existingReviewImages = review.getReviewImages();

                if (existingReviewImages == null) {
                    existingReviewImages = new ArrayList<>();
                }

                List<ReviewImage> filteredImages = imageList.stream()
                        .filter(image -> Long.valueOf(image.getReviewId()).equals(review.getReviewId()))
                        .collect(Collectors.toList());

                // 将筛选出的图片路径逐个添加到 existingReviewImages 中
                for (ReviewImage filteredImage : filteredImages) {
                    existingReviewImages.addAll(filteredImage.getImagePath());
                }

                review.setReviewImages(existingReviewImages);
            }
            pageResult.setList(reviewList);
        }
        
        return ResultGenerator.genSuccessResult(pageResult);
    }
    

    @RequestMapping(value = "/review/scores", method = RequestMethod.GET)
    @ResponseBody
    public Result scores(@RequestParam Map<String, Object> params) {
    	
    	Long goodsId = Long.valueOf(params.get("goodsId").toString());
        String skuId = params.get("skuId").toString();
    	Scores scores = reviewService.getInfoOfScores(goodsId,skuId);
    	
    	return ResultGenerator.genSuccessResult(scores);
    }
    
}
	