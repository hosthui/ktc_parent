<#import "function.ftl" as func>
<#assign package=model.variables.package>
<#assign class=model.variables.class>
<#assign classVar=model.variables.classVar>
<#assign comment=model.tabComment>
<#assign subtables=model.subTableList>
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
<#assign foreignField="">
<#if (model.sub)>
	<#assign foreignField=model.foreignKey?lower_case>
</#if>
package ${domain}.${system}.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Description ${comment}实体类
 * @author ${vars.developer}
 * @date ${date?string("yyyy-MM-dd HH:mm:ss")}
 */
@Entity
@Table(name="${tableName}")
public class ${class} implements Serializable{

	@Id
	private ${pkModel.colType} ${func.convertUnderLine(pkModel.columnName)};//主键ID

	<#list commonList as col>
	<#assign colName=func.convertUnderLine(col.columnName)>
	<#if func.isExcludeField( colName) >
	private ${col.colType} ${colName}; //${col.comment}
	</#if>
	</#list>

	public ${pkModel.colType} get${func.convertUnderLine(pkModel.columnName)?cap_first}() {
		return this.${func.convertUnderLine(pkModel.columnName)};
	}

	public void set${func.convertUnderLine(pkModel.columnName)?cap_first}(${pkModel.colType} aValue) {
		this.${func.convertUnderLine(pkModel.columnName)} = aValue;
	}
	
	<#list commonList as col>
	<#assign colName=func.convertUnderLine(col.columnName)>
	<#if func.isExcludeField( colName) >
	public void set${colName?cap_first}(${col.colType} ${colName}) {
		this.${colName} = ${colName};
	}

	public ${col.colType} get${colName?cap_first}() {
		return this.${colName};
	}
	</#if>
	</#list>

}



