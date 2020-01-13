package com.julius.base.common.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Package: com.julius.base.common.config
 * @ClassName: SwaggerConfiguration
 * @Author: Julius
 * @Description: swagger2文档工具配置类
 * @Date: 2020/1/13 13:27
 * @Version: 1.0
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {


    @Bean
    public Docket swaggerDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .apis(RequestHandlerSelectors.basePackage("com.julius.base.common.controller"))
                .build();
    }

    /**
     * @Description 构建文档信息
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title("Base Architecture project - common module")
                //版本号
                .version("V1.0.0")
                .contact(new Contact("Julius Zhou", null, null))
                //描述
                .description("common module api document")
                .build();
    }

}
