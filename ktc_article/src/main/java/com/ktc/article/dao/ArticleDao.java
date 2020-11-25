package com.ktc.article.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ktc.article.pojo.Article;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * @Description 文章 数据访问接口
 * @date 2020-11-25 12:25:17
*/
public interface ArticleDao extends JpaRepository<Article,String>,JpaSpecificationExecutor<Article>{
	
	@Query("update Article a set a.state=1 where a.id=?1")
	@Modifying
	void upExamine(String articleId);
	
	@Query("update Article a set a.thumbup=a.thumbup+1 where a.id=?1")
	@Modifying
	void upThumbup(String articleId);
}

