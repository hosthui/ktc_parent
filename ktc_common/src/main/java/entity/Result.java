package entity;

public class Result  {
//响应状态码
	private Integer code;
	//是否成功
	private Boolean flag;
	//消息
	private String message;
	//响应前端数据
	private Object data;

	public Result() {
	}
	
	public Result(Integer code, Boolean flag, String message) {
		this.code = code;
		this.flag = flag;
		this.message = message;
	}
	
	public Result(Integer code, Boolean flag, String message, Object data) {
		this.code = code;
		this.flag = flag;
		this.message = message;
		this.data = data;
	}
	
	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
	
	public Boolean getFlag() {
		return flag;
	}
	
	public void setFlag(Boolean flag) {
		this.flag = flag;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
