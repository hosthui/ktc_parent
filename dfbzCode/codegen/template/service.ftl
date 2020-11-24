<#import "function.ftl" as func>
<#assign package=model.variables.package>
<#assign comment=model.tabComment>
<#assign class=model.variables.class>
<#assign classVar=model.variables.classVar>
<#assign system=vars.system>
<#assign domain=vars.domain>
<#assign pkType=func.getPkType(model)>
<#assign subtables=model.subTableList>
<#assign sub=model.sub>
<#assign commonList=model.commonList>
package ${domain}.${system}.service;

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
import ${domain}.${system}.dao.${class}Dao;
import ${domain}.${system}.pojo.${class};

/**
 * @Description ${comment} 服务层
 * @author ${vars.developer}
 * @date ${date?string("yyyy-MM-dd HH:mm:ss")}
*/
@Service
public class ${class}Service {

	@Autowired
	private ${class}Dao ${classVar}Dao;

	@Autowired
	private IdWorker idWorker;

	/**
	* 查询全部列表
	* @return
	*/
	public List<${class}> findAll() {
		return ${classVar}Dao.findAll();
	}

	/**
	* 条件查询+分页
	* @param whereMap
	* @param page
	* @param size
	* @return
	*/
	public Page<${class}> findSearch(Map whereMap, int page, int size) {
		Specification<${class}> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return ${classVar}Dao.findAll(specification, pageRequest);
	}

	/**
 	* 条件查询
	* @param whereMap
	* @return
	*/
	public List<${class}> findSearch(Map whereMap) {
		Specification<${class}> specification = createSpecification(whereMap);
		return ${classVar}Dao.findAll(specification);
	}

	/**
	* 根据ID查询实体
	* @param id
	* @return
	*/
	public ${class} findById(String id) {
		return ${classVar}Dao.findById(id).get();
	}

	/**
	* 增加
	* @param ${classVar}
	*/
	public void add(${class} ${classVar}) {
		${classVar}.setId( idWorker.nextId()+"" );
		${classVar}Dao.save(${classVar});
	}

	/**
	* 修改
	* @param ${classVar}
	*/
	public void update(${class} ${classVar}) {
		${classVar}Dao.save(${classVar});
	}

	/**
	* 删除
	* @param id
	*/
	public void deleteById(String id) {
		${classVar}Dao.deleteById(id);
	}

	/**
	* 动态条件构建
	* @param searchMap
	* @return
	*/
	private Specification<${class}> createSpecification(Map searchMap) {

		return new Specification<${class}>() {

			@Override
			public Predicate toPredicate(Root<${class}> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
				<#--// [columnComment]-->
				<#--if (searchMap.get("[column]")!=null && !"".equals(searchMap.get("[column]"))) {-->
				<#--predicateList.add(cb.like(root.get("[column]").as(String.class), "%"+(String)searchMap.get("[column]")+"%"));-->
				<#--}-->
				<#list commonList as col>
				<#assign colName=func.convertUnderLine(col.columnName)>
				<#if func.isExcludeField( colName) >
				//${col.comment}
				if (searchMap.get("${colName}")!=null && !"".equals(searchMap.get("${colName}"))) {
					predicateList.add(cb.like(root.get("${colName}").as(String.class), "%"+(String)searchMap.get("${colName}")+"%"));
				}
				</#if>
				</#list>

				return cb.and( predicateList.toArray(new Predicate[predicateList.size()]));
			}
		};
	}

}
