package com.ktc.spit.controller;


import com.ktc.spit.pojo.Spit;
import com.ktc.spit.service.SpitService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/spit")
public class SpitController {
	
	@Autowired
	SpitService spitService;
	
	@Autowired
	RedisTemplate redisTemplate;
	
	@RequestMapping(method = RequestMethod.POST)
	public Result insertSpit(@RequestBody Spit spit) {
		spitService.add(spit);
		return new Result(StatusCode.OK,true,"添加成功");
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public Result allSpit() {
		return new Result(StatusCode.OK,true,"查询成功",spitService.findAll());
	}
	
	@RequestMapping(value = "/{spitId}", method = RequestMethod.GET)
	public Result spitById(@PathVariable String spitId) {
		return new Result(StatusCode.OK,true,"查询成功",spitService.findOne(spitId));
	}
	
	@RequestMapping(value = "/{spitId}", method = RequestMethod.PUT)
	public Result updateSpit(@PathVariable String spitId,@RequestBody Spit spit) {
		spitService.updateOne(spit);
		return new Result(StatusCode.OK,true,"修改成功");
	}
	
	@RequestMapping(value = "/{spitId}", method = RequestMethod.DELETE)
	public Result delSpit(@PathVariable String spitId) {
		spitService.delOne(spitId);
		return new Result(StatusCode.OK,true,"删除成功");
	}
	
	@RequestMapping(value = "/comment/{parentid}/{page}/{size}",method = RequestMethod.GET)
	public Result comment(@PathVariable String parentid,
	                      @PathVariable Integer page,
	                      @PathVariable Integer size){
		Page<Spit> spits = spitService.selectPage(parentid, page, size);
		return new Result(StatusCode.OK,true,"查询成功",
				new PageResult<>((int)spits.getTotalElements(),spits.getContent()));
		
	}
	
	@RequestMapping(value = "/thumbup/{spitId}",method = RequestMethod.PUT)
	public Result thumbup(@PathVariable String spitId){
		
		String uid="3";
		
		Object flag = redisTemplate.opsForValue().get("spit:" + uid + ":" + spitId);
		if ( flag==null ){
			spitService.thumbup(spitId);
			redisTemplate.opsForValue().set("spit:" + uid + ":" + spitId,"1");
			return new Result(StatusCode.OK,true,"点赞成功");
		}else {
			spitService.unthumbup(spitId);
			redisTemplate.delete("spit:" + uid + ":" + spitId);
			return new Result(StatusCode.OK,true,"取消点赞");
		}
		
	}
}
