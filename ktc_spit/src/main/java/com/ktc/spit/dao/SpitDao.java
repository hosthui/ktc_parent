package com.ktc.spit.dao;

import com.ktc.spit.pojo.Spit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface SpitDao extends MongoRepository<Spit,String> {
	Page<Spit> findAllByParentid(String parentid, Pageable pageable);
}
