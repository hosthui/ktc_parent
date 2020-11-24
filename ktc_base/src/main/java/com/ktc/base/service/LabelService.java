package com.ktc.base.service;


import com.ktc.base.dao.LabelDao;
import com.ktc.base.entity.Label;
import entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import util.IdWorker;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
	
	public Specification<Label> createSpec(Map map){
		
		return new Specification<Label>() {
			@Override
			public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
				List<Predicate> pres=new ArrayList<>();
				if ( map.containsKey("id")&&map.get("id")!=null &&!"".equals(map.get("id")) ){
					Expression<String> id = root.get("id").as(String.class);
					Predicate id1 = criteriaBuilder.equal(id, map.get("id"));
					pres.add(id1);
				}
				if ( map.containsKey("labelname")&&map.get("labelname")!=null &&!"".equals(map.get("labelname")) ){
					Expression<String> labelname = root.get("labelname").as(String.class);
					Predicate prelabelname = criteriaBuilder.like(labelname,
							"%"+map.get("labelname")+"%");
					pres.add(prelabelname);
				}
				if ( map.containsKey("state")&&map.get("state")!=null &&!"".equals(map.get("state")) ){
					Expression<String > state =
							root.get("state").as(String.class);
					Predicate prestate = criteriaBuilder.equal(state, map.get("state"));
					pres.add(prestate);
				}
				if ( map.containsKey("count")&&map.get("count")!=null &&!"".equals(map.get("count")) ){
					Expression<Integer> count =
							root.get("count").as(Integer.class);
					Predicate precount = criteriaBuilder.equal(count, map.get("count"));
					pres.add(precount);
				}
				if ( map.containsKey("recommend")&&map.get("recommend")!=null &&
						!"".equals(map.get("recommend")) ){
					Expression<String> recommend = root.get("recommend").as(String.class);
					Predicate prerecommend = criteriaBuilder.like(recommend,
							"%"+map.get("recommend")+"%");
					pres.add(prerecommend);
				}
				Predicate[] predicates = pres.toArray(new Predicate[pres.size()]);
				return criteriaBuilder.and(predicates);
			}
		};
		
	}
	
	
	
	public List<Label> search(Map<String,Object> searchKey){
		Specification<Label> spec = createSpec(searchKey);
		return labelDao.findAll(spec);
	}
	
	public PageResult<Label> pageSearch(Map<String,Object> searchKey,
	                                    Integer page,Integer size){
		Specification<Label> spec = createSpec(searchKey);
		
		Page<Label> all = labelDao.findAll(spec, PageRequest.of(page - 1, size));
		
		return new PageResult<>(all.getTotalPages(),all.getContent());
		
	}
}
