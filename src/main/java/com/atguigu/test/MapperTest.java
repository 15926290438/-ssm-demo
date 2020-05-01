package com.atguigu.test;

import java.util.HashMap;
import java.util.List;

import javax.swing.plaf.synth.SynthSeparatorUI;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.atguigu.bean.Department;
import com.atguigu.bean.Emploer;
import com.atguigu.dao.DepartmentMapper;
import com.atguigu.dao.EmployeeMapper;

/**
 * 测试dao层的工作
 * @author 79056
 *推荐Spring的项目就可以使用spring的单元测试，可以自动注入我们需要的组件
 * 使用这个注解ContextConfiguration指定spring配置文件的位置
 * ContextConfiguration有一个属性叫locations，是一个数组
 * RunWith是junit的注解
 * 运行单元测试的时候你可以用哪个单元测试来运行，我们用的是spring的单元测试模块，RunWith（value）的value值就是
 * SpringJunit4ClassRunner.class
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MapperTest {
	@Autowired
	DepartmentMapper departmentMapper;
	@Autowired
	EmployeeMapper employeeMapper;
@Test
public void testCrud(){
	//1.创建SpringIOC容器
	ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
	//2.从容器中获取mapper
	DepartmentMapper bean = ioc.getBean(DepartmentMapper.class);
System.out.println(bean);
//	departmentMapper.insertDepartment(new Department("计算机7"));
  //  System.out.println(departmentMapper.findDepart("计算机"));
    
    List<Emploer>  resultFind =    employeeMapper.getEmployees();
    System.out.println(resultFind);
    
    System.out.println(departmentMapper.findDepart1("计算机"));
    String a = departmentMapper.findDepart1("计算机").get("dname");
}
}
