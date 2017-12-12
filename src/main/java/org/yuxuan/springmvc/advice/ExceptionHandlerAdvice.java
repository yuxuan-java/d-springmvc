package org.yuxuan.springmvc.advice;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
/**
 * 使用@ControllerAdvice声明一个控制器建言
 * 	@ControllerAdvice 组合了@Component注解，所以会自动注册为Spring的Bean
 *
 * @author yuxuan.han
 */
@ControllerAdvice
public class ExceptionHandlerAdvice {
	
	/**
	 * @ExceptionHandler 在此处定义全局处理，通过value属性可过滤拦截的条件
	 * 		在此处是拦截所有的Exception
	 * @param exception
	 * @param request
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	public ModelAndView exception(Exception exception, WebRequest request) {
		ModelAndView model = new ModelAndView("error");
		model.addObject("errorMessage", exception.getMessage());
		return model;
	}
	
	/**
	 * 使用@ModelAttribute注解将键值添加到全局
	 * 	所有注解的@RequestMapping方法都可以获得此键值对
	 * @param model
	 */
	@ModelAttribute
	public void addAttribute(Model model) {
		model.addAttribute("msg", "额外信息");
	}
	
	/**
	 * 通过@InitBinder注解定制WebDataBinder
	 * @param webDataBinder
	 */
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		//	忽略request参数的id
		webDataBinder.setDisallowedFields("id");
		//	更多WebDataBinder配置，参考WebDataBinder的API文档
	}
	
}
