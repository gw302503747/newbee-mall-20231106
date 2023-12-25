/**
 * 严肃声明：
 * 开源版本请务必保留此注释头信息，若删除我方将保留所有法律责任追究！
 * 本系统已申请软件著作权，受国家版权局知识产权以及国家计算机软件著作权保护！
 * 可正常分享和学习源码，不得用于违法犯罪活动，违者必究！
 * Copyright (c) 2019-2020 十三 all rights reserved.
 * 版权所有，侵权必究！
 */
package ltd.newbee.mall.service.impl;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import ltd.newbee.mall.common.NewBeeMallCategoryLevelEnum;
import ltd.newbee.mall.common.ServiceResultEnum;
import ltd.newbee.mall.controller.vo.NewBeeMallSearchGoodsVO;
import ltd.newbee.mall.controller.vo.NewBeeMallUserVO;
import ltd.newbee.mall.dao.QAMapper;
import ltd.newbee.mall.entity.GoodsCategory;
import ltd.newbee.mall.entity.NewBeeMallGoods;
import ltd.newbee.mall.entity.QA;
import ltd.newbee.mall.entity.UserHistory;
import ltd.newbee.mall.service.QAService;
import ltd.newbee.mall.util.BeanUtil;
import ltd.newbee.mall.util.NewBeeMallUtils;
import ltd.newbee.mall.util.PageQueryUtil;
import ltd.newbee.mall.util.PageResult;

@Service
public class QAServiceImpl implements QAService {

    @Autowired
    private QAMapper qaMapper;
  
	@Override
	public String saveQuestions(QA qa) {
		qa.setCreateTime(new Date());
		if (qaMapper.insertQusetion(qa)>0) {
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
	}
	

    @Override
    public PageResult getQuestionList(PageQueryUtil pageUtil) {
        List<QA> qaList = qaMapper.findQuestionList(pageUtil);
        int total = qaMapper.getTotalQuestions(pageUtil);
        
        PageResult pageResult = new PageResult(qaList, total, pageUtil.getLimit(), pageUtil.getPage());
        return pageResult;
    }
    
    @Override
    public int updateAnswer(Object questionId) {
        return qaMapper.updateAnswer(questionId);
    }

}