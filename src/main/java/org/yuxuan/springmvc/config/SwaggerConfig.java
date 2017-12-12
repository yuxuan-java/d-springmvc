package org.yuxuan.springmvc.config;

import org.springframework.context.annotation.Configuration;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;

@Configuration
@EnableSwagger
public class SwaggerConfig {
	
	private SpringSwaggerConfig springSwaggerConfig;

	public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig) {
		this.springSwaggerConfig = springSwaggerConfig;
	}
	
	public SwaggerSpringMvcPlugin customImplementation() {
		//	Patterns支持正则匹配，只有这里配置了页面才能看到
		return new SwaggerSpringMvcPlugin(this.springSwaggerConfig).apiInfo(apiInfo()).includePatterns("/*");
	}

	private ApiInfo apiInfo() {
		ApiInfo apiInfo = new ApiInfo(null, null, null, null, null, null);
		return apiInfo;
	}
	
}
