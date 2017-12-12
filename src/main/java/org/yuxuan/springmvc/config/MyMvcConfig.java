package org.yuxuan.springmvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
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
	
	/**
	 * 使用重写addViewController方法来简化页面跳转的配置
	 */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/index").setViewName("/index");
		registry.addViewController("/toUpload").setViewName("/upload");
	}
	
	/**
	 * 在SpringMvc中，路径参数如果带"."，"."后面的值会被忽略
	 * 	例如访问  http://localhost:8080/d-springmvc/anno/pathvar/xx.yy
	 * 	此时"."后面的yy将被忽略
	 */
	@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {
		//	通过重写configurePathMatch方法可以不忽略"."后的参数
		configurer.setUseSuffixPatternMatch(false);
	}
	
	@Bean
	public MultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(1000000);
		return multipartResolver;
	}

}
