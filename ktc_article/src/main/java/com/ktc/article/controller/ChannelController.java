package com.ktc.article.controller;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ktc.article.pojo.Channel;
import com.ktc.article.service.ChannelService;

import entity.PageResult;
import entity.Result;
import entity.StatusCode;

/**
* @Description 频道 控制器层
* @author admin
* @date 2020-11-25 12:25:56
*/
@RestController
@CrossOrigin
@RequestMapping("/channel")
public class ChannelController{

@Autowired
private ChannelService channelService;

/**
* 查询全部数据
* @return
*/
@RequestMapping(method= RequestMethod.GET)
public Result findAll(){
return new Result(StatusCode.OK,true,"查询成功",channelService.findAll());
}

/**
* 根据ID查询
* @param id ID
* @return
*/
@RequestMapping(value="/{id}",method= RequestMethod.GET)
public Result findById(@PathVariable String id){
return new Result(StatusCode.OK,true,"查询成功",channelService.findById(id));
}

/**
* 分页+多条件查询
* @param searchMap 查询条件封装
* @param page 页码
* @param size 页大小
* @return 分页结果
*/
@RequestMapping(value="/search/{page}/{size}",method=RequestMethod.POST)
public Result findSearch(@RequestBody Map searchMap , @PathVariable int page, @PathVariable int size){
Page<Channel> pageList = channelService.findSearch(searchMap, page, size);
return  new Result(StatusCode.OK,true,"查询成功",  new PageResult<Channel>((int)pageList.getTotalElements(), pageList.getContent()) );
}

/**
* 根据条件查询
* @param searchMap
* @return
*/
@RequestMapping(value="/search",method = RequestMethod.POST)
public Result findSearch( @RequestBody Map searchMap){
return new Result(StatusCode.OK,true,"查询成功", channelService.findSearch(searchMap));
}

/**
* 增加
* @param channel
*/
@RequestMapping(method=RequestMethod.POST)
public Result add(@RequestBody  Channel  channel  ){
channelService.add( channel);
return new Result(StatusCode.OK,true,"增加成功");
}

/**
* 修改
* @param channel
*/
@RequestMapping(value="/{id}",method= RequestMethod.PUT)
public Result update(@RequestBody  Channel  channel, @PathVariable String id ){
channel.setId(id);
channelService.update( channel);
return new Result(StatusCode.OK,true,"修改成功");
}

/**
* 删除
* @param id
*/
@RequestMapping(value="/{id}",method= RequestMethod.DELETE)
public Result delete(@PathVariable String id ){
channelService.deleteById(id);
return new Result(StatusCode.OK,true,"删除成功");
}

}
