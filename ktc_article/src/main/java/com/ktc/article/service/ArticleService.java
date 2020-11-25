package com.ktc.article.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.IdWorker;
import com.ktc.article.dao.ArticleDao;
import com.ktc.article.pojo.Article;

/**
 * @Description 文章 服务层
 * @author admin
 * @date 2020-11-25 12:25:18
*/
@Service
public class ArticleService {

	@Autowired
	private ArticleDao articleDao;

	@Autowired
	private IdWorker idWorker;

	
	@Autowired
	private RedisTemplate redisTemplate;
	/**
	* 查询全部列表
	* @return
	*/
	public List<Article> findAll() {
		return articleDao.findAll();
	}

	/**
	* 条件查询+分页
	* @param whereMap
	* @param page
	* @param size
	* @return
	*/
	public Page<Article> findSearch(Map whereMap, int page, int size) {
		Specification<Article> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return articleDao.findAll(specification, pageRequest);
	}

	/**
 	* 条件查询
	* @param whereMap
	* @return
	*/
	public List<Article> findSearch(Map whereMap) {
		Specification<Article> specification = createSpecification(whereMap);
		return articleDao.findAll(specification);
	}

	/**
	* 根据ID查询实体
	* @param id
	* @return
	*/
	public Article findById(String id) {
		Article article =
				(Article)redisTemplate.opsForValue().get("article:"+id);
		if ( article==null ){
			article=articleDao.findById(id).get();
			redisTemplate.opsForValue().set("article:"+id,article);
		}
		return article;
	}

	/**
	* 增加
	* @param article
	*/
	public void add(Article article) {
		article.setId( idWorker.nextId()+"" );
		articleDao.save(article);
	}

	/**
	* 修改
	* @param article
	*/
	public void update(Article article) {
		redisTemplate.opsForValue().set("article:"+article.getId(),article);
		articleDao.save(article);
	}

	/**
	* 删除
	* @param id
	*/
	public void deleteById(String id) {
		redisTemplate.delete("article:"+id);
		articleDao.deleteById(id);
	}

	/**
	* 动态条件构建
	* @param searchMap
	* @return
	*/
	private Specification<Article> createSpecification(Map searchMap) {

		return new Specification<Article>() {

			@Override
			public Predicate toPredicate(Root<Article> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
				//专栏ID
				if (searchMap.get("columnid")!=null && !"".equals(searchMap.get("columnid"))) {
					predicateList.add(cb.like(root.get("columnid").as(String.class), "%"+(String)searchMap.get("columnid")+"%"));
				}
				//用户ID
				if (searchMap.get("userid")!=null && !"".equals(searchMap.get("userid"))) {
					predicateList.add(cb.like(root.get("userid").as(String.class), "%"+(String)searchMap.get("userid")+"%"));
				}
				//标题
				if (searchMap.get("title")!=null && !"".equals(searchMap.get("title"))) {
					predicateList.add(cb.like(root.get("title").as(String.class), "%"+(String)searchMap.get("title")+"%"));
				}
				//文章正文
				if (searchMap.get("content")!=null && !"".equals(searchMap.get("content"))) {
					predicateList.add(cb.like(root.get("content").as(String.class), "%"+(String)searchMap.get("content")+"%"));
				}
				//文章封面
				if (searchMap.get("image")!=null && !"".equals(searchMap.get("image"))) {
					predicateList.add(cb.like(root.get("image").as(String.class), "%"+(String)searchMap.get("image")+"%"));
				}
				//发表日期
				if (searchMap.get("createtime")!=null && !"".equals(searchMap.get("createtime"))) {
					predicateList.add(cb.like(root.get("createtime").as(String.class), "%"+(String)searchMap.get("createtime")+"%"));
				}
				//修改日期
				if (searchMap.get("updatetime")!=null && !"".equals(searchMap.get("updatetime"))) {
					predicateList.add(cb.like(root.get("updatetime").as(String.class), "%"+(String)searchMap.get("updatetime")+"%"));
				}
				//是否公开
				if (searchMap.get("ispublic")!=null && !"".equals(searchMap.get("ispublic"))) {
					predicateList.add(cb.like(root.get("ispublic").as(String.class), "%"+(String)searchMap.get("ispublic")+"%"));
				}
				//是否置顶
				if (searchMap.get("istop")!=null && !"".equals(searchMap.get("istop"))) {
					predicateList.add(cb.like(root.get("istop").as(String.class), "%"+(String)searchMap.get("istop")+"%"));
				}
				//浏览量
				if (searchMap.get("visits")!=null && !"".equals(searchMap.get("visits"))) {
					predicateList.add(cb.like(root.get("visits").as(String.class), "%"+(String)searchMap.get("visits")+"%"));
				}
				//点赞数
				if (searchMap.get("thumbup")!=null && !"".equals(searchMap.get("thumbup"))) {
					predicateList.add(cb.like(root.get("thumbup").as(String.class), "%"+(String)searchMap.get("thumbup")+"%"));
				}
				//评论数
				if (searchMap.get("comment")!=null && !"".equals(searchMap.get("comment"))) {
					predicateList.add(cb.like(root.get("comment").as(String.class), "%"+(String)searchMap.get("comment")+"%"));
				}
				//审核状态
				if (searchMap.get("state")!=null && !"".equals(searchMap.get("state"))) {
					predicateList.add(cb.like(root.get("state").as(String.class), "%"+(String)searchMap.get("state")+"%"));
				}
				//所属频道
				if (searchMap.get("channelid")!=null && !"".equals(searchMap.get("channelid"))) {
					predicateList.add(cb.like(root.get("channelid").as(String.class), "%"+(String)searchMap.get("channelid")+"%"));
				}
				//URL
				if (searchMap.get("url")!=null && !"".equals(searchMap.get("url"))) {
					predicateList.add(cb.like(root.get("url").as(String.class), "%"+(String)searchMap.get("url")+"%"));
				}
				//类型
				if (searchMap.get("type")!=null && !"".equals(searchMap.get("type"))) {
					predicateList.add(cb.like(root.get("type").as(String.class), "%"+(String)searchMap.get("type")+"%"));
				}

				return cb.and( predicateList.toArray(new Predicate[predicateList.size()]));
			}
		};
	}
	@Transactional
	public void examine(String articleId){
	articleDao.upExamine(articleId);
	}
	
	@Transactional
	public void thumbup(String articleId){
		articleDao.upThumbup(articleId);
	}
}
