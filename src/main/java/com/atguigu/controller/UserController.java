package com.atguigu.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.atguigu.bean.Department;
import com.atguigu.bean.ReturnRecord;
import com.atguigu.bean.User;
import com.atguigu.services.UserServices;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping(value="/system")
public class UserController {
	
	@Autowired
	UserServices userservice;
	
	@RequestMapping(value="/login/{user}/{pas}")
	public ReturnRecord login(@PathVariable(value="user") String user1, @PathVariable(value="pas") String pas1){
		SimpleDateFormat a = new SimpleDateFormat("yyyyMMddHHmmss");
		System.out.println(a.format(new Date()));
		return	userservice.getUser(user1, pas1);
     
	}
	
	@RequestMapping(value="/loginCheck")
	@ResponseBody
	public ReturnRecord loginCheck(User user,HttpServletRequest request) {
		ReturnRecord result =	userservice.getUser(user.getName(), user.getPassword());
		User userQueryInDateSource = result.getUser();
		if(userQueryInDateSource!=null){
			HttpSession session = request.getSession();
			session.setAttribute("User", userQueryInDateSource);
		}
		return result;
	}
	
	
	@RequestMapping(value="/loginCheck1")
	@ResponseBody
	public ReturnRecord loginCheck( String name,String password,HttpServletRequest request) {
		ReturnRecord result =	userservice.getUser(name, password);
		User userQueryInDateSource = result.getUser();
		if(userQueryInDateSource!=null){
			HttpSession session = request.getSession();
			session.setAttribute("User", userQueryInDateSource);
		}
		return result;
	}
	
	
	
	@RequestMapping(value="/Check")
	public void test(@RequestBody Map<String,Object> map){
		
		System.out.println(map.get("user"));
      ObjectMapper mapper = new ObjectMapper();
     User a =  mapper.convertValue(map.get("user"), User.class);
           User b =  mapper.convertValue(map.get("user"), new TypeReference<User>(){});
     System.out.println(b.getName());

		
	}
	
	@RequestMapping(value="/Check1")
	public void test1(@RequestParam Map<String,String> map) throws IOException{
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmdd");
		String fileName = format.format(new Date())+"CreationEntilement";
	String guid = 	UUID.randomUUID().toString();
	System.out.println(guid);
	File f =new File("/a.txt");
	System.out.println(f.getAbsolutePath());   
	//D:\eclipse\eclipse\a.txt 因为当前项目的工作目录是D:\eclipse\eclipse
	//可在Run Configurations->Arguments -> Working Directory看到
	
	File f1 =new File("/b.txt");
	System.out.println(f1.getAbsolutePath());  //D:\b.txt  发现直接到了盘符下了    路径前面有/ 代表绝对路径
	
	System.out.println(UserController.class.getResource(""));
	FileOutputStream fos = new FileOutputStream("a.txt");
	byte[] b = {65,66,67};
	fos.write(b);
	
		System.out.println(map.get("name"));
	}
	
}
