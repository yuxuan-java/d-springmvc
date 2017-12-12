package org.yuxuan.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.yuxuan.springmvc.domain.DemoObj;

@Controller
public class AdviceController {
	
	@RequestMapping("/advice")
	public String getSomething(@ModelAttribute("msg") String msg, DemoObj obj) {
		throw new IllegalArgumentException("很抱歉，参数有误/" + "来自@ModelAttribute: " + msg);
	}
	
}
