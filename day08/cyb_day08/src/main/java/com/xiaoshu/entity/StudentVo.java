package com.xiaoshu.entity;

import javax.persistence.Transient;

public class StudentVo extends Student{
	@Transient
	private String cname;

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}
	
	
	
}
