package com.cafe.wedding.base.domain;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import javax.persistence.PersistenceContext;


@MappedSuperclass
public class BaseDomain implements Serializable{
	private static final long serialVersionUID = 702465083984609980L;
	
	@Basic
	@Column(columnDefinition="TIMESTAMP")
	protected Date inputtime;//输入时间
	@Basic
	@Column(columnDefinition="TIMESTAMP")
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
