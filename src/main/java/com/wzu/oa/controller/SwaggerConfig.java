package com.wzu.oa.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by jack on 16/9/19.
 */
@Configuration
@EnableSwagger2
@EnableWebMvc
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.wzu.oa.controller"))
                .paths(PathSelectors.any()).build();
    }


    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "微小型企业OA系统api接口文档",
                "提供详细的后台所有restful接口",
                "0.0.1",
                "",
                "王国建",
                "Apache License Version 2.0",
                "");
        return apiInfo;
    }

}
