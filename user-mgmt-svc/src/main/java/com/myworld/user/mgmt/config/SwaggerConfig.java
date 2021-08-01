package com.myworld.user.mgmt.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

  @Autowired
  private Environment env;

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)//
        .select()//
        .apis(RequestHandlerSelectors.basePackage(env.getProperty("application.groupid")))//
        // .paths(PathSelectors.regex("/app"))//
        .build()//
        .apiInfo(metadata())//
        .useDefaultResponseMessages(false)//
        .securitySchemes(new ArrayList<>(Arrays.asList(new ApiKey("Authorization", "Bearer %token", "Header"))))//
        .genericModelSubstitutes(Optional.class);

  }

  private ApiInfo metadata() {
    return new ApiInfoBuilder()//
        .title(env.getProperty("application.name"))//
        // .description(env.getProperty("application.description"))//
        .version(env.getProperty("application.version"))//
        // .contact(new Contact(null, null, "rajamohan.mupp@gmail.com"))//
        .build();
  }

}
