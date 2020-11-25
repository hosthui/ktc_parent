package com.ktc.article.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ktc.article.pojo.Column;

/**
 * @Description 专栏 数据访问接口
 * @date 2020-11-25 12:25:00
*/
public interface ColumnDao extends JpaRepository<Column,String>,JpaSpecificationExecutor<Column>{

}

