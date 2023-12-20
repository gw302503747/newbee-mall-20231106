/**
 * 严肃声明：
 * 开源版本请务必保留此注释头信息，若删除我方将保留所有法律责任追究！
 * 本系统已申请软件著作权，受国家版权局知识产权以及国家计算机软件著作权保护！
 * 可正常分享和学习源码，不得用于违法犯罪活动，违者必究！
 * Copyright (c) 2019-2020 十三 all rights reserved.
 * 版权所有，侵权必究！
 */
package ltd.newbee.mall.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.List;

public class Sku {
    
    private Long goodsId;
    private String skuId;
    private Long stock;
    private String goodsSize;
    private String goodsColor;
    private List<String> skuImages;
    
	public Long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public String getSkuId() {
		return skuId;
	}

	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}

	public Long getStock() {
		return stock;
	}

	public void setStock(Long stock) {
		this.stock = stock;
	}

	public String getGoodsSize() {
		return goodsSize;
	}

	public void setGoodsSize(String goodsSize) {
		this.goodsSize = goodsSize;
	}

	public String getGoodsColor() {
		return goodsColor;
	}

	public void setGoodsColor(String goodsColor) {
		this.goodsColor = goodsColor;
	}

	public List<String> getSkuImages() {
		return skuImages;
	}

	public void setSkuImages(List<String> skuImages) {
		this.skuImages = skuImages;
	}

	@Override
	public String toString() {
		return "Sku [goodsId=" + goodsId + ", skuId=" + skuId + ", stock=" + stock + ", goodsSize=" + goodsSize
				+ ", goodsColor=" + goodsColor + ", skuImages=" + skuImages + "]";
	}

	
}