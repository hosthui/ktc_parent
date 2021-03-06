package com.ktc.base.controller;


import com.ktc.base.entity.Label;
import com.ktc.base.service.LabelService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/label")
public class LabelController {
	
	@Autowired
	LabelService labelService;
	
	@RequestMapping(method = RequestMethod.POST)
	public Result save(@RequestBody Label label){
		
		labelService.save(label);
		return new Result(StatusCode.OK,true,"添加成功");
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	public Result delete(@PathVariable String id){
		
		labelService.delete(id);
	return new Result(StatusCode.OK,true,"删除成功");
	}
	@RequestMapping(value = "/{id}",method = RequestMethod.PUT)
	public Result update(@PathVariable String id,@RequestBody Label label){
	label.setId(id);
	labelService.update(label);
		return new Result(StatusCode.OK,true,"修改成功");
	}
	@RequestMapping("/{id}")
	public Result findOne(@PathVariable String id){
		Label label = labelService.findOne(id);
		return new Result(StatusCode.OK,true,"查询成功",label);
	}
	@RequestMapping(value = "search",method = RequestMethod.POST)
	public Result search(@RequestBody Map<String,Object> map){
		return new Result(StatusCode.OK,true,"查询成功",labelService.search(map));
	}
	@RequestMapping(value = "search/{page}/{size}",method = RequestMethod.POST)
	public Result pageSearch(@RequestBody Map<String,Object> map,
	                                    @PathVariable Integer page,
	                                    @PathVariable Integer size){
		return new Result(StatusCode.OK,true,"查询成功",
				labelService.pageSearch(map,page,size));
	}
}
