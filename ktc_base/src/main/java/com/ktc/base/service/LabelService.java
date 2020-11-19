package com.ktc.base.service;


import com.ktc.base.dao.LabelDao;
import com.ktc.base.entity.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.IdWorker;

import java.util.Optional;

@Service
public class LabelService {
	@Autowired
	LabelDao labelDao;
	
	
	@Autowired
	IdWorker idWorker;
	
	public int save(Label label){
		label.setId(idWorker.nextId()+"");
		Label save = labelDao.save(label);
		System.out.println(save);
		return 1;
	}
	public void  delete(String id){
		labelDao.deleteById(id);
	}
	public void update(Label label){
		labelDao.save(label);
	}
	public Label findOne(String id){
		Optional<Label> byId = labelDao.findById(id);
		return byId.get();
	}
}
