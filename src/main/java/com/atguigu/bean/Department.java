package com.atguigu.bean;

public class Department {
private int did;
private String dname;
public int getDid() {
	return did;
}
public void setDid(int did) {
	this.did = did;
}
public String getDname() {
	return dname;
}
public void setDname(String dname) {
	this.dname = dname;
}
public Department( String dname) {
	
	
	this.dname = dname;
}

Department(){}

@Override
public String toString() {
	return "Department [did=" + did + ", dname=" + dname + "]";
}

}
