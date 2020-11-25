package com.ktc.article.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ktc.article.pojo.Channel;

/**
 * @Description 频道 数据访问接口
 * @date 2020-11-25 12:25:56
*/
public interface ChannelDao extends JpaRepository<Channel,String>,JpaSpecificationExecutor<Channel>{

}

