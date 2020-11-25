package com.ktc.qa.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ktc.qa.pojo.Problem;
import org.springframework.data.jpa.repository.Query;

/**
 * @Description 问题 数据访问接口
 * @date 2020-11-25 10:41:11
*/
public interface ProblemDao extends JpaRepository<Problem,String>,JpaSpecificationExecutor<Problem>{
	
	//SELECT p.* FROM tb_problem p WHERE p.id in (SELECT pl.problemid FROM tb_pl pl WHERE pl.labelid=1)
	@Query("select p from Problem p where p.id in (select pl.problemid from " +
			"Pl pl where pl.labelid=?1) order by createtime")
	Page<Problem> findNewList(String label, Pageable pageable);
	
	//SELECT p.* FROM tb_problem p WHERE p.id in (SELECT pl.problemid FROM tb_pl pl WHERE pl.labelid=1) and  (p.reply=0 or p.reply is null)
	//ORDER BY createtime DESC
	@Query("select p from Problem p where p.id in (select pl.problemid from " +
			"Pl pl where pl.labelid=?1) and (p.reply=0 or p.reply is null) order by createtime")
	Page<Problem> findWaitList(String label, Pageable pageable);
}

