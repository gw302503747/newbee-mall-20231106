/**
 * 严肃声明：
 * 开源版本请务必保留此注释头信息，若删除我方将保留所有法律责任追究！
 * 本系统已申请软件著作权，受国家版权局知识产权以及国家计算机软件著作权保护！
 * 可正常分享和学习源码，不得用于违法犯罪活动，违者必究！
 * Copyright (c) 2019-2020 十三 all rights reserved.
 * 版权所有，侵权必究！
 */
package ltd.newbee.mall.dao;

import ltd.newbee.mall.entity.IndexConfig;
import ltd.newbee.mall.entity.UserHistory;
import ltd.newbee.mall.util.PageQueryUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IndexConfigMapper {
	int deleteByPrimaryKey(Long configId);

	int insert(IndexConfig record);

	int insertSelective(IndexConfig record);

	IndexConfig selectByPrimaryKey(Long configId);

	IndexConfig selectByTypeAndGoodsId(@Param("configType") int configType, @Param("goodsId") Long goodsId);

	int updateByPrimaryKeySelective(IndexConfig record);

	int updateByPrimaryKey(IndexConfig record);

	List<IndexConfig> findIndexConfigList(PageQueryUtil pageUtil);

	int getTotalIndexConfigs(PageQueryUtil pageUtil);

	int deleteBatch(Long[] ids);

	List<IndexConfig> findIndexConfigsByTypeAndNum(@Param("configType") int configType, @Param("number") int number);
	
	List<UserHistory> findUserHistoryByNum(@Param("userId") long userId,@Param("number") int number);
}