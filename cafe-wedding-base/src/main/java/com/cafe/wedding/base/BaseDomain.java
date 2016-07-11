package com.cafe.wedding.base;

import java.io.Serializable;
import java.sql.Date;


public class BaseDomain implements Serializable{
	private static final long serialVersionUID = 702465083984609980L;
	
	protected Date inputtime;//输入时间
	protected Date updatetime;//更新时间
	protected String creater;//创建人
	protected String operator;//最后一次操作人
	public Date getInputtime() {
		return inputtime;
	}
	public void setInputtime(Date inputtime) {
		this.inputtime = inputtime;
	}
	public Date getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	public String getCreater() {
		return creater;
	}
	public void setCreater(String creater) {
		this.creater = creater;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	
}
