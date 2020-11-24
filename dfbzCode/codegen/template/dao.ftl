<#import "function.ftl" as func>
<#assign package=model.variables.package>
<#assign class=model.variables.class>
<#assign classVar=model.variables.classVar>
<#assign comment=model.tabComment>
<#assign system=vars.system>
<#assign domain=vars.domain>
<#assign sub=model.sub>
<#assign foreignKey=func.convertUnderLine(model.foreignKey)>
<#assign pkType=func.getPkType(model)>
<#assign fkType=func.getFkType(model)>
package ${domain}.${system}.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ${domain}.${system}.pojo.${class};

/**
 * @Description ${comment} 数据访问接口
 * @date ${date?string("yyyy-MM-dd HH:mm:ss")}
*/
public interface ${class}Dao extends JpaRepository<${class},String>,JpaSpecificationExecutor<${class}>{

}

