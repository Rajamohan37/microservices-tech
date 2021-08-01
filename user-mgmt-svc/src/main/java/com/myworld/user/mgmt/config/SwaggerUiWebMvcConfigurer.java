package com.myworld.user.mgmt.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

public class SwaggerUiWebMvcConfigurer implements WebMvcConfigurer {
	private final String baseUrl;
	
	@Value("${base-package}")
	private String basePackage;

	public SwaggerUiWebMvcConfigurer(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		String baseUrl = StringUtils.trimTrailingCharacter(this.baseUrl, '/');
		registry.addResourceHandler(baseUrl + "/swagger-ui/**")
				.addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/")
				.resourceChain(false);
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController(baseUrl + "/swagger-ui/")
				.setViewName("forward:" + baseUrl + "/swagger-ui/index.html");
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.OAS_30)
				// To Enable Secure logins
				// .securitySchemes(new ArrayList<>(Arrays.asList(new ApiKey("Authorization",
				// "Bearer %token", "Header"))))
				.useDefaultResponseMessages(false).select()
				.apis(RequestHandlerSelectors.basePackage(basePackage)).build().apiInfo(metadata())
				.genericModelSubstitutes(Optional.class);
	}

	private ApiInfo metadata() {
		return new ApiInfoBuilder()//
				.title("Supplier Service")//
				.description("Supplier Service")//
				.version("0.0.1")//
				.contact(new Contact(null, null, "rajamohan.mupp@gmail.com"))//
				.build();
	}

}