package com.ktc.spit.service;


import com.ktc.spit.dao.SpitDao;
import com.ktc.spit.pojo.Spit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import util.IdWorker;

import java.util.Date;
import java.util.List;

@Service
public class SpitService {
	
	@Autowired
	SpitDao spitDao;
	@Autowired
	IdWorker idWorker;
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	
	public void add(Spit spit) {
		spit.setId(idWorker.nextId() + "");
		spit.setPublishtime(new Date());//发布日期
		spit.setVisits(0);//浏览量
		spit.setShare(0);//分享数
		spit.setThumbup(0);//点赞数
		if(spit.getComment()==null){
			spit.setComment(0);//回复数
		}
		spit.setState("1");//状态
		if(spit.getParentid()!=null && !spit.getParentid().equals("")){
			Query query = new Query();
			 query.addCriteria(Criteria.where("_id").is(spit.getParentid()));
			Update update = new Update();
			update.inc("comment",1);
			
			
			mongoTemplate.updateFirst(query,update,"spit");
		}
		spitDao.save(spit);
	}
	
	public List<Spit> findAll() {
		return spitDao.findAll();
	}
	
	public Spit findOne(String spitId) {
		return spitDao.findById(spitId).get();
	}
	
	public void updateOne(Spit spit) {
		spitDao.save(spit);
	}
	
	public void delOne(String spitId) {
		spitDao.deleteById(spitId);
	}
	
	public Page<Spit> selectPage(String parentid, Integer page, Integer size) {
		return spitDao.findAllByParentid(parentid, PageRequest.of(page-1,size));
	}
	
	public void thumbup(String spitId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(spitId));
		Update update = new Update();
		update.inc("thumbup",1);
		mongoTemplate.updateFirst(query,update,"spit");
	}
	
	public void unthumbup(String spitId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(spitId));
		Update update = new Update();
		update.inc("thumbup",-1);
		mongoTemplate.updateFirst(query,update,"spit");
	}
}
