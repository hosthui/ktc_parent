<#import "function.ftl" as func>
<#assign package=model.variables.package>
<#assign class=model.variables.class>
<#assign classVar=model.variables.classVar>
<#assign comment=model.tabComment>
<#assign pk=func.getPk(model) >
<#assign pkModel=model.pkModel >
<#assign pkVar=func.convertUnderLine(pk) >
<#assign pkType=func.getPkType(model)>
<#assign fkType=func.getFkType(model)>
<#assign system=vars.system>
<#assign domain=vars.domain>
<#assign tableName=model.tableName>
<#assign colList=model.columnList>
<#assign commonList=model.commonList>
package ${domain}.${system}.controller;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ${domain}.${system}.pojo.${class};
import ${domain}.${system}.service.${class}Service;

import entity.PageResult;
import entity.Result;
import entity.StatusCode;

/**
* @Description ${comment} 控制器层
* @author ${vars.developer}
* @date ${date?string("yyyy-MM-dd HH:mm:ss")}
*/
@RestController
@CrossOrigin
@RequestMapping("/${classVar}")
public class ${class}Controller{

@Autowired
private ${class}Service ${classVar}Service;

/**
* 查询全部数据
* @return
*/
@RequestMapping(method= RequestMethod.GET)
public Result findAll(){
return new Result(StatusCode.OK,true,"查询成功",${classVar}Service.findAll());
}

/**
* 根据ID查询
* @param id ID
* @return
*/
@RequestMapping(value="/{id}",method= RequestMethod.GET)
public Result findById(@PathVariable String id){
return new Result(StatusCode.OK,true,"查询成功",${classVar}Service.findById(id));
}

/**
* 分页+多条件查询
* @param searchMap 查询条件封装
* @param page 页码
* @param size 页大小
* @return 分页结果
*/
@RequestMapping(value="/search/{page}/{size}",method=RequestMethod.POST)
public Result findSearch(@RequestBody Map searchMap , @PathVariable int page, @PathVariable int size){
Page<${class}> pageList = ${classVar}Service.findSearch(searchMap, page, size);
return  new Result(StatusCode.OK,true,"查询成功",  new PageResult<${class}>(pageList.getTotalElements(), pageList.getContent()) );
}

/**
* 根据条件查询
* @param searchMap
* @return
*/
@RequestMapping(value="/search",method = RequestMethod.POST)
public Result findSearch( @RequestBody Map searchMap){
return new Result(StatusCode.OK,true,"查询成功", ${classVar}Service.findSearch(searchMap));
}

/**
* 增加
* @param ${classVar}
*/
@RequestMapping(method=RequestMethod.POST)
public Result add(@RequestBody  ${class}  ${classVar}  ){
${classVar}Service.add( ${classVar});
return new Result(StatusCode.OK,true,"增加成功");
}

/**
* 修改
* @param ${classVar}
*/
@RequestMapping(value="/{id}",method= RequestMethod.PUT)
public Result update(@RequestBody  ${class}  ${classVar}, @PathVariable String id ){
${classVar}.setId(id);
${classVar}Service.update( ${classVar});
return new Result(StatusCode.OK,true,"修改成功");
}

/**
* 删除
* @param id
*/
@RequestMapping(value="/{id}",method= RequestMethod.DELETE)
public Result delete(@PathVariable String id ){
${classVar}Service.deleteById(id);
return new Result(StatusCode.OK,true,"删除成功");
}

}
