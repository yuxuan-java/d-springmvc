package org.yuxuan.springmvc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yuxuan.springmvc.domain.DemoObj;
/**
 * 使用@RestController声明是控制器，并且返回数据时不需要@ResponseBody
 *
 * @author yuxuan.han
 */
@RestController
@RequestMapping("/rest")
public class DemoRestController {
	
	/**
	 * 返回数据为Json
	 * 		直接返回对象，会自动转换成Json
	 * @param obj
	 * @return
	 */
	@RequestMapping(value = "/getJson", produces = "application/json;charset=UTF-8")
	public DemoObj getJson(DemoObj obj) {
		return new DemoObj(obj.getId() + 1, obj.getName() + "_new");
	}
	
	/**
	 * 返回数据为Xml
	 * 		直接返回对象，会自动转换成Xml
	 * @param obj
	 * @return
	 */
	@RequestMapping(value = "/getXml", produces = {"application/xml;charset=UTF-8"})
	public DemoObj getXml(DemoObj obj) {
		return new DemoObj(obj.getId() + 1, obj.getName() + "_new");
	}

}
