package com.atguigu.bean;

public class Emploer {
	private int eid;
    private String name;
    private String sex;
    private int age;
    private Department department;
    Emploer(){}
	public Emploer(int eid, String name, String sex, int age, Department department) {
		this.eid = eid;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.department = department;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}

    
    
    
}
