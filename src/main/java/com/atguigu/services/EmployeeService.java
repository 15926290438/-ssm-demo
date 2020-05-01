package com.atguigu.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.bean.Emploer;
import com.atguigu.dao.EmployeeMapper;

@Service   
//将这个注解写到类上，标注将这个类交给Spring容器管理，Spring容器要为它创建对象
public class EmployeeService {

	@Autowired
	EmployeeMapper employeeMapper;
	
	public List<Emploer> getEmploers(){
		
		return employeeMapper.getEmployees();
	}
	
	public int deleteEmployee(int id){
	return	employeeMapper.deleteEmployee(id);
	}
	
}
