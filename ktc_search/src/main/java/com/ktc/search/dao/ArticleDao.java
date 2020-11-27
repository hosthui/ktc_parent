package com.ktc.search.dao;

import com.ktc.search.pojo.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ArticleDao extends ElasticsearchRepository<Article,String> {
	Page<Article> findByTitleLikeOrContentLike(String keywords,
	                                           String keywords1, Pageable of);
}
