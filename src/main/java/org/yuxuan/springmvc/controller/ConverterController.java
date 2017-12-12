package org.yuxuan.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.yuxuan.springmvc.domain.DemoObj;

@Controller
public class ConverterController {
	
	/**
	 * 指定返回的媒体类型为自定义的新媒体类型:x-wisely
	 * @param demoObj
	 * @return
	 */
	@RequestMapping(value = "/convert", produces = {"application/x-wisely"})
	public @ResponseBody DemoObj converter(@RequestBody DemoObj demoObj) {
		return demoObj;
	}
	
}
