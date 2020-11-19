package entity;

import java.util.List;

public class PageResult<T> {
	//总记录数
	private Integer total;
	//每页的数据
	private List<T> rows;
	
	public PageResult() {
	}
	
	public PageResult(Integer total, List<T> rows) {
		this.total = total;
		this.rows = rows;
	}
	
	public Integer getTotal() {
		return total;
	}
	
	public void setTotal(Integer total) {
		this.total = total;
	}
	
	public List<T> getRows() {
		return rows;
	}
	
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
}
