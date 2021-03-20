package com.joker.crm.common.config;

import java.util.Collections;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *
 * @author Mr.Joker
 * @date 2021/03/18
 * @time 12:44:24
 * @description swagger2配置类，支持多包扫描
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * 该方法配置了swagger2可以扫描暴露的接口
     * @return
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(basePackage("com.joker.crm.controller", ";"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(new ApiInfo("CRM接口文档",
                    "简单的CRM接口文档",
                    "API V0.1",
                    "",
                    new Contact("mr.joker", "https://github.com/OnePieceJoker", "joker_lizhih@163.com"),
                    "",
                    "",
                    Collections.emptyList()));
    }
    
    /**
     * 自定义多包扫描路径，仿照{@link RequestHandlerSelectors}类下面的basePackage方法实现自己的逻辑
     * @param basePackage
     * @param splitor
     * @return
     */
    public static Predicate<RequestHandler> basePackage(final String basePackage, final String splitor) {
        return input -> declaringClass(input).transform(handlerPackage(basePackage, splitor)).or(true);
    }

    private static Function<Class<?>, Boolean> handlerPackage(final String basePackage, final String splitor) {
        return input -> {
            for (String strPackage : basePackage.split(splitor)) {
                boolean isMatch = input.getPackage().getName().startsWith(strPackage);
                if (isMatch) { 
                    return true;
                }
            }
            return false;
        };
    }

    private static Optional<? extends Class<?>> declaringClass(RequestHandler input) {
        return Optional.fromNullable(input.declaringClass());
    }
}
