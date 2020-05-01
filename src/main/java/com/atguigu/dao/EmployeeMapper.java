package com.atguigu.dao;

import java.util.List;

import com.atguigu.bean.Emploer;

public interface EmployeeMapper {
//在mabatis中，映射文件的namaspace是用于绑定Dao接口的，即面向接口编程
	//当你的namespace绑定了接口，你可以不用写接口实现类，mybatis会通过这个绑定，找你你要执行的SQL语句
	List<Emploer> getEmployees();
	
	//删除员工
	int deleteEmployee(int id);
	
}
