package com.yurets_y.utl2planchart.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/test").setViewName("test");
        registry.addViewController("/map").setViewName("other/map");
        registry.addViewController("/users").setViewName("users/users");
        registry.addViewController("/login").setViewName("users/login");
//        registry.addViewController("/layout").setViewName("layout");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
//        registry.addResourceHandler("/static/css/**")
//                .addResourceLocations("classpath:/static/css/");
    }


}
