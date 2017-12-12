package org.yuxuan.springmvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.yuxuan.springmvc.interceptor.DemoInterceptor;

@Configuration
@EnableWebMvc// 开启一些spring默认配置
@ComponentScan("org.yuxuan.springmvc")
public class MyMvcConfig extends WebMvcConfigurerAdapter {// 继承WebMvcConfigurerAdapter类，重新方法可对SpringMvc进行配置

	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		//	视图解析器
		viewResolver.setPrefix("/WEB-INF/classes/views/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setViewClass(JstlView.class);
		return viewResolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//	文件放置的目录
		ResourceHandlerRegistration registration = registry.addResourceHandler("/assets/**");
		//	对外暴露的路径
		registration.addResourceLocations("classpath:/assets/");
	}
	
	@Bean
	public DemoInterceptor demoInterceptor() {
		return new DemoInterceptor();
	}
	
	/**
	 * 重写addInterceptorRegistry方法注册拦截器
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(demoInterceptor());
	}

}
