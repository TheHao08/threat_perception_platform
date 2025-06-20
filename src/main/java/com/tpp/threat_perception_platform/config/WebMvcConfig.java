package com.tpp.threat_perception_platform.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 主页
        registry.addViewController("/page/index").setViewName("index");
        registry.addViewController("/").setViewName("index");
        // 控制台
        registry.addViewController("/page/console").setViewName("console");
        // 登录页面
        registry.addViewController("/page/login").setViewName("login");
        // 用户相关页面
        registry.addViewController("/page/user/list").setViewName("user/list");
        registry.addViewController("/page/user/edit").setViewName("user/edit");
        registry.addViewController("/page/user/add").setViewName("user/add");

        // 角色相关页面
        registry.addViewController("/page/role/list").setViewName("role/list");
        registry.addViewController("/page/role/edit").setViewName("role/edit");
        registry.addViewController("/page/role/add").setViewName("role/add");

        // 主机相关页面
        registry.addViewController("/page/host/list").setViewName("host/list");
        registry.addViewController("/page/host/assets").setViewName("host/assets");


    }
}
