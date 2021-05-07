package com.luca.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestAttribute;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo())
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.luca"))
            .paths(PathSelectors.any())
            .build()
            .ignoredParameterTypes(RequestAttribute.class);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Demo")
            .description("测试")
            .version("0.1.1-SNAPSHOT")
            .build();
    }
    
}