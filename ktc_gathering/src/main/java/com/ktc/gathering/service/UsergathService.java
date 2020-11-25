package com.ktc.gathering.service;

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
import org.springframework.stereotype.Service;
import util.IdWorker;
import com.ktc.gathering.dao.UsergathDao;
import com.ktc.gathering.pojo.Usergath;

/**
 * @Description 用户关注活动 服务层
 * @author admin
 * @date 2020-11-25 14:01:41
*/
@Service
public class UsergathService {

	@Autowired
	private UsergathDao usergathDao;

	@Autowired
	private IdWorker idWorker;

	/**
	* 查询全部列表
	* @return
	*/
	public List<Usergath> findAll() {
		return usergathDao.findAll();
	}

	/**
	* 条件查询+分页
	* @param whereMap
	* @param page
	* @param size
	* @return
	*/
	public Page<Usergath> findSearch(Map whereMap, int page, int size) {
		Specification<Usergath> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return usergathDao.findAll(specification, pageRequest);
	}

	/**
 	* 条件查询
	* @param whereMap
	* @return
	*/
	public List<Usergath> findSearch(Map whereMap) {
		Specification<Usergath> specification = createSpecification(whereMap);
		return usergathDao.findAll(specification);
	}

	/**
	* 根据ID查询实体
	* @param id
	* @return
	*/
	public Usergath findById(String id) {
		return usergathDao.findById(id).get();
	}

	/**
	* 增加
	* @param usergath
	*/
	public void add(Usergath usergath) {
		usergath.setUserid( idWorker.nextId()+"" );
		usergathDao.save(usergath);
	}

	/**
	* 修改
	* @param usergath
	*/
	public void update(Usergath usergath) {
		usergathDao.save(usergath);
	}

	/**
	* 删除
	* @param id
	*/
	public void deleteById(String id) {
		usergathDao.deleteById(id);
	}

	/**
	* 动态条件构建
	* @param searchMap
	* @return
	*/
	private Specification<Usergath> createSpecification(Map searchMap) {

		return new Specification<Usergath>() {

			@Override
			public Predicate toPredicate(Root<Usergath> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
				//点击时间
				if (searchMap.get("exetime")!=null && !"".equals(searchMap.get("exetime"))) {
					predicateList.add(cb.like(root.get("exetime").as(String.class), "%"+(String)searchMap.get("exetime")+"%"));
				}

				return cb.and( predicateList.toArray(new Predicate[predicateList.size()]));
			}
		};
	}

}
