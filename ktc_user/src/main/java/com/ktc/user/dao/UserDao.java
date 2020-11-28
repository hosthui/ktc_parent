package com.ktc.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ktc.user.pojo.User;

/**
 * @Description 用户 数据访问接口
 * @date 2020-11-27 16:51:43
*/
public interface UserDao extends JpaRepository<User,String>,JpaSpecificationExecutor<User>{
	
	
	User findByMobile(String mobile);

}

