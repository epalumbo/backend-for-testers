package com.calipsoide.backend4testers.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.HashSet;

import static java.util.Collections.singletonList;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("users-api-1")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.calipsoide.backend4testers.controllers"))
                .build()
                .apiInfo(new ApiInfoBuilder().title("Users API")
                        .description("An API for managing users")
                        .version("1")
                        .build())
                .consumes(new HashSet<>(singletonList(APPLICATION_JSON_VALUE)))
                .produces(new HashSet<>(singletonList(APPLICATION_JSON_VALUE)));
    }

}