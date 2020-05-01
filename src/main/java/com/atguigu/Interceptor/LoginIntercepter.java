package com.atguigu.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.atguigu.bean.User;

public class LoginIntercepter implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler)
			throws Exception {
		HttpSession session = httpServletRequest.getSession();
		System.out.println(session.getServletContext());
	Object user = 	session.getAttribute("User");
	//设置会话超时的时间
	session.setMaxInactiveInterval(5*60);
     User userLogin = (User)user;
   
     // 获取到项目名，以便下面进行重定向
     String homeUrl = httpServletRequest.getContextPath();

     if(userLogin!=null){
    	 if(userLogin.getName()!=null)
    	 return true;
     }else{
		 	// 如果是 ajax 请求，则设置 session 状态 、CONTEXTPATH 的路径值
		 	// 如果是ajax请求响应头会有，x-requested-with
		    if (httpServletRequest.getHeader("x-requested-with") != null && httpServletRequest.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")){
		        httpServletResponse.setHeader("SESSIONSTATUS", "TIMEOUT");
		        httpServletResponse.setHeader("CONTEXTPATH", homeUrl+"/");
		        // FORBIDDEN，forbidden。也就是禁止、403
		        httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN); 
		    }else{
		        // 如果不是 ajax 请求，则直接跳转即可
		        httpServletResponse.sendRedirect(homeUrl+"/");
		    	 return false; // 如果此处不返回false, 则springMvc会继续对“/”路径进行处理，就会出现多次返回响应的错误。
		    }
     }
    return true;
    
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
           
		
	}

}
