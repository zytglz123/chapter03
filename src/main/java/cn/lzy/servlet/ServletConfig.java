package cn.lzy.servlet;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServletConfig {
    @Bean
    public ServletRegistrationBean getServlet(MyServlet myServlet){
        ServletRegistrationBean registrationBean =
                new ServletRegistrationBean(myServlet,"/myServlet");
        return registrationBean;
    }
}
