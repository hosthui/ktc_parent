package com.ktc.user.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ktc.user.pojo.Admin;
import com.ktc.user.service.AdminService;

import entity.PageResult;
import entity.Result;
import entity.StatusCode;

/**
 * @author admin
 * @Description 管理员 控制器层
 * @date 2020-11-27 16:52:19
 */
@RestController
@CrossOrigin
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	/**
	 * 查询全部数据
	 *
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public Result findAll() {
		return new Result(StatusCode.OK, true, "查询成功", adminService.findAll());
	}
	
	/**
	 * 根据ID查询
	 *
	 * @param id ID
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Result findById(@PathVariable String id) {
		return new Result(StatusCode.OK, true, "查询成功", adminService.findById(id));
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
		Page<Admin> pageList = adminService.findSearch(searchMap, page, size);
		return new Result(StatusCode.OK, true, "查询成功", new PageResult<Admin>((int)pageList.getTotalElements(), pageList.getContent()));
	}
	
	/**
	 * 根据条件查询
	 *
	 * @param searchMap
	 * @return
	 */
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public Result findSearch(@RequestBody Map searchMap) {
		return new Result(StatusCode.OK, true, "查询成功", adminService.findSearch(searchMap));
	}
	
	/**
	 * 增加
	 *
	 * @param admin
	 */
	@RequestMapping(method = RequestMethod.POST)
	public Result add(@RequestBody Admin admin) {
		adminService.add(admin);
		return new Result(StatusCode.OK, true, "增加成功");
	}
	
	/**
	 * 修改
	 *
	 * @param admin
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Result update(@RequestBody Admin admin, @PathVariable String id) {
		admin.setId(id);
		adminService.update(admin);
		return new Result(StatusCode.OK, true, "修改成功");
	}
	
	/**
	 * 删除
	 *
	 * @param id
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Result delete(@PathVariable String id) {
		adminService.deleteById(id);
		return new Result(StatusCode.OK, true, "删除成功");
	}
	
	@RequestMapping(value = "login",method = RequestMethod.POST)
	public Result login(@RequestBody Admin admin){
		
		
		admin=adminService.login(admin);
		if ( admin==null ){
			return new Result(StatusCode.USER_PASSWORD_ERROR,false,"用户名或者密码错误");
		}
		
		
		return new Result(StatusCode.OK,true,"登录成功");
	}
	
}
