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
import java.util.Map;
import java.util.Objects;

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

import ltd.newbee.mall.common.Constants;
import ltd.newbee.mall.common.NewBeeMallException;
import ltd.newbee.mall.common.ServiceResultEnum;
import ltd.newbee.mall.controller.vo.NewBeeMallGoodsDetailVO;
import ltd.newbee.mall.controller.vo.SearchPageCategoryVO;
import ltd.newbee.mall.entity.NewBeeMallGoods;
import ltd.newbee.mall.entity.Question;
import ltd.newbee.mall.service.NewBeeMallQuestionService;
import ltd.newbee.mall.util.PageQueryUtil;
import ltd.newbee.mall.util.Result;
import ltd.newbee.mall.util.ResultGenerator;

@Controller
public class QuestionController {

    @Resource
    private NewBeeMallQuestionService newBeeMallQuestionService;

  /*  
    @RequestMapping(value = "/questions", method = RequestMethod.GET)
    @ResponseBody
    public Result getQuestionAndAnswer(@RequestParam long questionId) {
    	List<Question> list = newBeeMallQuestionService.getQuestionAndAnswer(questionId);
    	return ResultGenerator.genSuccessResult(list); 
    		    }
    */

    @RequestMapping(value = "/questions", method = RequestMethod.GET)
    @ResponseBody
    public Result questions(@RequestBody List<Long> questionId) {
    	List<Long> list = newBeeMallQuestionService.getQuestionById(questionId);
    	return ResultGenerator.genSuccessResult(list); 
    		    }
    
    @RequestMapping(value = "/questions/delete", method = RequestMethod.POST)
    @ResponseBody
    public Result delete(@RequestBody List<Long> questionId) {
            return ResultGenerator.genSuccessResult(
            		newBeeMallQuestionService.deleteQuestionById(questionId));
    }
    
    @RequestMapping(value = "/questions/update", method = RequestMethod.POST)
    @ResponseBody
    public Result update(@RequestBody Map<String, Object> questionId) {
             return ResultGenerator.genSuccessResult(newBeeMallQuestionService.updateQuestionById(questionId));
    }
    
    @RequestMapping(value = "/questions/list", method = RequestMethod.GET)
    @ResponseBody
    public Result list(@RequestParam Map<String, Object> params) {
        if (ObjectUtils.isEmpty(params.get("page")) || ObjectUtils.isEmpty(params.get("limit"))) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        PageQueryUtil pageUtil = new PageQueryUtil(params);
        return ResultGenerator.genSuccessResult(newBeeMallQuestionService.getQuestionPage(pageUtil));
    }

    
}
	