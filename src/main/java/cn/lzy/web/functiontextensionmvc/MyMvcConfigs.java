package cn.lzy.web.functiontextensionmvc;

import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class MyMvcConfigs implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/toLoginPage").setViewName("login");
        registry.addViewController("/toLoginPage1").setViewName("login");
        registry.addViewController("/login.html").setViewName("login");
    }
}
