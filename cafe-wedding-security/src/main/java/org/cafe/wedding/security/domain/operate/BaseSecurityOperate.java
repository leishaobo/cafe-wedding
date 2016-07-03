package org.cafe.wedding.security.domain.operate;

/**
 *<pre>
 *	操作行为
 *</pre>
 * @author leishaobo
 * @email leishaobo_cafe@163.com
 * @createime 2016年7月1日
 *
 */
public enum BaseSecurityOperate {
	INSERT("insert","插入"),
	UPDATE("update","更新"),
	SELECT("select","查询"),
	DELETE("delete","删除");
	//ALL("all","所有权限");
	private String code;
	private String desc;
	BaseSecurityOperate(String code,String desc){
		this.code=code;
		this.desc=desc;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}
