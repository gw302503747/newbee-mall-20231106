/**
 * 严肃声明：
 * 开源版本请务必保留此注释头信息，若删除我方将保留所有法律责任追究！
 * 本系统已申请软件著作权，受国家版权局知识产权以及国家计算机软件著作权保护！
 * 可正常分享和学习源码，不得用于违法犯罪活动，违者必究！
 * Copyright (c) 2019-2020 十三 all rights reserved.
 * 版权所有，侵权必究！
 */
package ltd.newbee.mall.controller.mall;


import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import ltd.newbee.mall.controller.vo.NewBeeMallGoodsDetailVO;
import ltd.newbee.mall.controller.vo.SearchPageCategoryVO;
import ltd.newbee.mall.entity.NewBeeMallGoods;
import ltd.newbee.mall.entity.Question;
import ltd.newbee.mall.entity.Sku;
import ltd.newbee.mall.entity.SkuImage;
import ltd.newbee.mall.service.SkuService;
import ltd.newbee.mall.util.PageQueryUtil;
import ltd.newbee.mall.util.Result;
import ltd.newbee.mall.util.ResultGenerator;
import ltd.newbee.mall.util.SkuColumnManagementUtil;

@Controller
public class SkuController {

    @Resource
    private SkuService skuService;
    
    @RequestMapping(value = "/sku", method = RequestMethod.GET)
    @ResponseBody
    public Result list(@RequestParam Map<String, Object> params) {
    	List<Sku> sku =skuService.getSkuListByIdAndName(params.get("goodsId"),params.get("goodsSize"),params.get("goodsColor")); 
    	List<SkuImage> imageList=skuService.getSkuImageByIdAndName(params.get("goodsId"),params.get("goodsSize"),params.get("goodsColor")); 
    	List<Sku> mergedList = new ArrayList<>(sku);
        
     // 收集 skuImage 字段的值到一个数组，并确保包含 "image1" 和 "image2"
        List<String> skuImages = imageList.stream()
                .map(SkuImage::getSkuImage)
                .filter(skuImage -> skuImage != null && !skuImage.isEmpty())
                .distinct()
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        mergedList.forEach(skuItem -> skuItem.setSkuImages(new ArrayList<>(skuImages)));
    	
    	return ResultGenerator.genSuccessResult(mergedList);
    }

    

    
}