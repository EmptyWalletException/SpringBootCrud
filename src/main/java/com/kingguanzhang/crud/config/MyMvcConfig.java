package com.kingguanzhang.crud.config;

import com.kingguanzhang.crud.component.LoginHandlerInterceptor;
import com.kingguanzhang.crud.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 扩展springMvc
 */
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {
    @Override
    /*注册视图解析器,所有在localhost:8080后面加上的路径会被springMvc以返回的字符串解析
    并在templates路径下寻找对应的html*/
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/test").setViewName("success");
        registry.addViewController("/test.html").setViewName("success");
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index").setViewName("login");
        registry.addViewController("/index.html").setViewName("login");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/login.html").setViewName("login");
        registry.addViewController("/board").setViewName("dashboard");
        registry.addViewController("/board.html").setViewName("dashboard");
        registry.addViewController("/loginRedirect").setViewName("dashboard");
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/","/index","/login","/index.html","/login.html","/user/login","/**/*.css","/**/*.js");

    }

    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }
}
