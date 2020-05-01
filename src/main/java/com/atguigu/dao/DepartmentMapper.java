package com.atguigu.dao;

import java.util.Map;

import com.atguigu.bean.Department;

public interface DepartmentMapper {
int insertDepartment(Department record);
  Department findDepart(String dname) ;
  
  Map<String,String> findDepart1(String danme);
}
