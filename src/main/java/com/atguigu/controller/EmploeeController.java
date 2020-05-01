package com.atguigu.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.atguigu.bean.Emploer;
import com.atguigu.services.EmployeeService;

@Controller
@RequestMapping(value="/emp")
public class EmploeeController {

	@Autowired
	EmployeeService employeeService;
	

@RequestMapping("/delete")
@ResponseBody
public String deleteEmplyee(int id){
	employeeService.deleteEmployee(id);
	return "/list";
}
	
	
	
	
  @RequestMapping(value="/list")
  @ResponseBody  
//ResponseBody 用于将Controller返回的对象，通过SpringMvc的HttpMessageConverter转换成指定格式的数据(如json,xml)，通过Response响应给客户端
  public List<Emploer> getEmployees(HttpServletRequest request){
	  List<Emploer> emploerList	=  employeeService.getEmploers();
	  HttpSession session = request.getSession();
	  session.setAttribute("list", emploerList);
	return  emploerList;
	  
  }
  
  
  @RequestMapping(value="/list1")
  @ResponseBody  
  //用来测试的，发现ajax需要接收json格式的数据，如果单单返回一个String是不能自动转换成json格式的
//ResponseBody 用于将Controller返回的对象，通过SpringMvc的HttpMessageConverter转换成指定格式的数据(如json,xml)，通过Response响应给客户端
  public Map<String,String> getEmployees1(HttpServletRequest request){
	  List<Emploer> emploerList	=  employeeService.getEmploers();
	  HttpSession session = request.getSession();
	  session.setAttribute("list", emploerList);
	  String a = "dgg";
	  Map<String,String> map = new HashMap<String,String>();
	  map.put("dtt", a);
	return  map;
	  
  }
	
}
