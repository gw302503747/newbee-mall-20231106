/**
 * 严肃声明：
 * 开源版本请务必保留此注释头信息，若删除我方将保留所有法律责任追究！
 * 本系统已申请软件著作权，受国家版权局知识产权以及国家计算机软件著作权保护！
 * 可正常分享和学习源码，不得用于违法犯罪活动，违者必究！
 * Copyright (c) 2019-2020 十三 all rights reserved.
 * 版权所有，侵权必究！
 */
package ltd.newbee.mall.service.impl;


import java.util.List;
import java.util.Map;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;

import ltd.newbee.mall.dao.SkuMapper;
import ltd.newbee.mall.entity.Sku;
import ltd.newbee.mall.entity.SkuImage;
import ltd.newbee.mall.service.SkuService;
import ltd.newbee.mall.util.SkuColumnManagementUtil;

@Service
public class SkuServiceImpl implements SkuService {

    @Autowired
    private SkuMapper skuMapper;
    
    @Override
	public List<Sku> getSkuListByIdAndName(Object goodsId, Object goodsSize, Object goodsColor) {
    	List<Sku> skuList = skuMapper.selectSkuByColumnName(goodsId, goodsSize, goodsColor);
		return skuList;
    }

    @Override
	public List<SkuImage> getSkuImageByIdAndName(Object goodsId, Object goodsSize, Object goodsColor) {
    	Sku sku = skuMapper.selectSkuIdByColumnName(goodsId, goodsSize, goodsColor);
    	List<SkuImage> skuImage = skuMapper.selectImageBySkuId(sku.getSkuId());
		return skuImage;
    }
	
/*
	@Override
	public Sku getGoodsById(SkuColumnManagementUtil skuColumnManagementUtil) {
		
		Sku defaultList = skuMapper.selectDefaultSku (skuColumnManagementUtil.getGoodsId());
		SkuColumnManagement skuCMEList = skuMapper.selectColumnByIdAndName(skuColumnManagementUtil);
		String column = skuCMEList.getSkuColumn();
		String skuName = skuCMEList.getSkuName();
		Sku skuList = new Sku();
		BeanUtils.copyProperties(skuList, defaultList);
		Method m = 

		Map<String, Object> team1 = new HashMap<String, Object>();
		
		int j = 0; //看多少个符合
    	int i = 0;
    	for( Sku sku : skuList ){
    		for( SkuColumnManagement skuColumnManagement: skuCMEList){
    			Object col1 = null;
				try {
					col1 = PropertyUtils.getSimpleProperty(skuCMEList, "skuColumn");
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    					
    			for ( String key : team1.keySet() ) {
    				Object skuText = null;
					try {
						skuText = PropertyUtils.getSimpleProperty(skuCMEList,"skuText");
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (NoSuchMethodException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
    			    if(skuText == key){
    			    	if(col1 == team1.get(key)){
    			    	  j++;
    			    	}
    			    }
    			}
    		}
    	  if( j == skuCMEList.size() ){
    	  	break;
    	  }
    	  i++;
    	}
    	Sku result = skuList.get(i);

    	//最终找到这条数据
        return result;
    }
	
	*/
	
}