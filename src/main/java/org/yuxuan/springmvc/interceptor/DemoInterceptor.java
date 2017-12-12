package org.yuxuan.springmvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class DemoInterceptor extends HandlerInterceptorAdapter {
	
	/**
	 * 请求前执行
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		long startTime = System.currentTimeMillis();
		request.setAttribute("startTime", startTime);
		
		return true;
	}
	
	/**
	 * 请求后执行
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		long startTime = (long) request.getAttribute("startTime");
		request.removeAttribute("startTime");
		long endTime = System.currentTimeMillis();
		long usedTime = endTime - startTime;
		
		System.out.println("######DemoInterceptor_本次请求处理时间为: " + usedTime + "ms");
		request.setAttribute("handlingTime", usedTime);
	}
	
}
