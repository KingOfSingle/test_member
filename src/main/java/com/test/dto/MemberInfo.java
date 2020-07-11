package com.test.dto;

public class MemberInfo {

	String name;
	String level;
	String dept;
	String del;
	
	public MemberInfo() {
		
	}
		
	public MemberInfo(String name, String level, String dept, String del) {
		super();
		this.name = name;
		this.level = level;
		this.dept = dept;
		this.del = del;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getDel() {
		return del;
	}
	public void setDel(String del) {
		this.del = del;
	}
	
	private MemberInfo instance;
	
	public MemberInfo getInstance() {
		if(instance == null) {
			instance = new MemberInfo();
		}
		
		return instance;
	}
}
