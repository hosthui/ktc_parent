package com.ktc.recruit.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ktc.recruit.pojo.Recruit;
import com.ktc.recruit.service.RecruitService;

import entity.PageResult;
import entity.Result;
import entity.StatusCode;

/**
 * @author admin
 * @Description 职位 控制器层
 * @date 2020-11-24 20:02:07
 */
@RestController
@CrossOrigin
@RequestMapping("/recruit")
public class RecruitController {
	
	@Autowired
	private RecruitService recruitService;
	
	/**
	 * 查询全部数据
	 *
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public Result findAll() {
		return new Result(StatusCode.OK, true, "查询成功", recruitService.findAll());
	}
	
	/**
	 * 根据ID查询
	 *
	 * @param id ID
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Result findById(@PathVariable String id) {
		return new Result(StatusCode.OK, true, "查询成功", recruitService.findById(id));
	}
	
	/**
	 * 分页+多条件查询
	 *
	 * @param searchMap 查询条件封装
	 * @param page      页码
	 * @param size      页大小
	 * @return 分页结果
	 */
	@RequestMapping(value = "/search/{page}/{size}", method = RequestMethod.POST)
	public Result findSearch(@RequestBody Map searchMap, @PathVariable int page, @PathVariable int size) {
		Page<Recruit> pageList = recruitService.findSearch(searchMap, page, size);
		return new Result(StatusCode.OK, true, "查询成功", new PageResult<Recruit>((int)pageList.getTotalElements(), pageList.getContent()));
	}
	
	/**
	 * 根据条件查询
	 *
	 * @param searchMap
	 * @return
	 */
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public Result findSearch(@RequestBody Map searchMap) {
		return new Result(StatusCode.OK, true, "查询成功", recruitService.findSearch(searchMap));
	}
	
	/**
	 * 增加
	 *
	 * @param recruit
	 */
	@RequestMapping(method = RequestMethod.POST)
	public Result add(@RequestBody Recruit recruit) {
		recruitService.add(recruit);
		return new Result(StatusCode.OK, true, "增加成功");
	}
	
	/**
	 * 修改
	 *
	 * @param recruit
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Result update(@RequestBody Recruit recruit, @PathVariable String id) {
		recruit.setId(id);
		recruitService.update(recruit);
		return new Result(StatusCode.OK, true, "修改成功");
	}
	
	/**
	 * 删除
	 *
	 * @param id
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Result delete(@PathVariable String id) {
		recruitService.deleteById(id);
		return new Result(StatusCode.OK, true, "删除成功");
	}
	
	@RequestMapping("/search/recommend")
	public Result recommend(){
		return new Result(StatusCode.OK,true,"查询成功",recruitService.recommend());
	}
	
	@RequestMapping("/search/newlist")
	public Result newlist(){
		return new Result(StatusCode.OK,true,"查询成功",recruitService.newlist());
	}
}
