package com.ktc.search.service;


import com.ktc.search.dao.ArticleDao;
import com.ktc.search.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import util.IdWorker;

@Service
public class ArticleService {
	@Autowired
	private ArticleDao articleDao;
	
	@Autowired
	private IdWorker idWorker;
	
	public void add(Article article) {
		article.setId(idWorker.nextId()+"");
		articleDao.save(article);
	}
	
	public Page<Article> search(String keywords, int page, int size) {
		
		return  articleDao.findByTitleLikeOrContentLike(keywords,keywords, PageRequest.of(page-1,size));
	}
}
