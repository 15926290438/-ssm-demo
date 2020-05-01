package com.atguigu.bean;

public class ReturnRecord {
private String errorMessege;
private String successMessege;
private User user;
public String getErrorMessege() {
	return errorMessege;
}
public void setErrorMessege(String errorMessege) {
	this.errorMessege = errorMessege;
}
public String getSuccessMessege() {
	return successMessege;
}
public void setSuccessMessege(String successMessege) {
	this.successMessege = successMessege;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public ReturnRecord(String errorMessege, String successMessege, User user) {
	this.errorMessege = errorMessege;
	this.successMessege = successMessege;
	this.user = user;
}
public ReturnRecord(){
	
}
}
