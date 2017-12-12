package org.yuxuan.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;
import org.yuxuan.springmvc.service.PushService;

@Controller
public class AysncController {
	
	@Autowired
	private PushService pushService;
	
	@RequestMapping("/deferr")
	public @ResponseBody DeferredResult<String> deferredCall() {
		return pushService.getAsyncUpdate();
	}
	
}
