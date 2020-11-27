package com.ktc.search.controller;


import com.ktc.search.pojo.Article;
import com.ktc.search.service.ArticleService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/article")
@CrossOrigin
public class ArticleController {
	@Autowired
	private ArticleService articleService;
	/**
	 * 添加一篇文章进elasticsearch
	 * @param article
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public Result add(@RequestBody Article article){
		articleService.add(article);
		return new Result( StatusCode.OK,true,"添加成功");
	}
	/**
	 * 在elasticsearch中查询数据并且分页
	 *  模糊分词匹配title和content
	 * @param keywords
	 * @param page
	 * @param size
	 * @return
	 */
	@RequestMapping(value = "/search/{keywords}/{page}/{size}", method = RequestMethod.GET)
	public Result search(@PathVariable String keywords, @PathVariable int page, @PathVariable int size) {
		Page<Article> pageData=articleService.search(keywords,page,size);
		return new Result(StatusCode.OK,true, "查询成功",new PageResult<>((int)pageData.getTotalElements(),pageData.getContent()));
	}
}
