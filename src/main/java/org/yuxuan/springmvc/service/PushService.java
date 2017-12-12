package org.yuxuan.springmvc.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

@Service
public class PushService {

	private DeferredResult<String> deferredResult;
	
	public DeferredResult<String> getAsyncUpdate() {
		//	在PushService里产生DeferredResult给Controller使用
		deferredResult = new DeferredResult<>();
		return deferredResult;
	}
	
	/**
	 * 使用@Scheduled注解的方法定时更新DeferredResult
	 */
	@Scheduled(fixedDelay = 5000)
	public void refresh() {
		if (deferredResult != null) {
			deferredResult.setResult(String.valueOf(System.currentTimeMillis()));
		}
	}
	
}
