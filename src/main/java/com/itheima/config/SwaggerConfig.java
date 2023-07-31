package com.itheima.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.ApiInfoBuilder;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket docket(Environment environment) {
        // 设置环境范围
        Profiles profiles = Profiles.of("pro","test");
        // 如果在该环境返回内则返回：true，反之返回 false
        boolean flag = environment.acceptsProfiles(profiles);

        // 创建一个 swagger 的 bean 实例
        return new Docket(DocumentationType.SWAGGER_2)
                // 配置基本信息
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.itheima.controller")).build()
                .groupName("TestDemo1")
                .enable(true);
    }

    // 基本信息设置
    private ApiInfo apiInfo() {
        Contact contact = new Contact(
                "李朋永", // 作者姓名
                "http://www.baidu.com", // 作者网址
                "13026031157@163.com"); // 作者邮箱
        return new ApiInfoBuilder()
                .title("导师的任务") // 标题
                .description("罗刹海市") // 描述
                .termsOfServiceUrl("https://www.baidu.com") // 跳转连接
                .version("1.0") // 版本
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
                .contact(contact)
                .build();
    }

    @Bean
    public Docket docket2(Environment environment) {
        // 设置环境范围
        Profiles profiles = Profiles.of("pro","test");
        // 如果在该环境返回内则返回：true，反之返回 false
        boolean flag = environment.acceptsProfiles(profiles);

        // 创建一个 swagger 的 bean 实例
        return new Docket(DocumentationType.SWAGGER_2)
                .select().apis(RequestHandlerSelectors.any()).build()
                .groupName("TestDemo2")
                .enable(true);
    }


}
