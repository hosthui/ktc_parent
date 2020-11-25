package com.ktc.gathering.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ktc.gathering.pojo.Usergath;

/**
 * @Description 用户关注活动 数据访问接口
 * @date 2020-11-25 14:01:41
*/
public interface UsergathDao extends JpaRepository<Usergath,String>,JpaSpecificationExecutor<Usergath>{

}

