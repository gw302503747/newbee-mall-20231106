package ltd.newbee.mall.util;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 分页查询参数
 *
 * @author 13
 * @qq交流群 796794009
 * @email 2449207463@qq.com
 * @link https://github.com/newbee-ltd
 */
public class SkuColumnManagementUtil extends LinkedHashMap<String, Object> {
    //当前商品种类id
    private long goodsId;
    //每个类别名
    private String skuName;

    public SkuColumnManagementUtil(Map<String, Object> params) {
        this.putAll(params);

        //分页参数
        this.goodsId = Integer.parseInt(params.get("goodsId").toString());
    }


    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public String getSkuName() {
		return skuName;
	}


	public void setSkuName(String skuName) {
		this.skuName = skuName;
	}

    @Override
    public String toString() {
        return "SkuColumnManagementUtil{" +
                "goodsId=" + goodsId +
                ", skuName=" + skuName +
                '}';
    }
}
