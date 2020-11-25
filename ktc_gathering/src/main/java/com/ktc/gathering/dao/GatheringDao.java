package com.ktc.gathering.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ktc.gathering.pojo.Gathering;

/**
 * @Description 活动 数据访问接口
 * @date 2020-11-25 14:01:12
*/
public interface GatheringDao extends JpaRepository<Gathering,String>,JpaSpecificationExecutor<Gathering>{

}

