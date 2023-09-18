package cn.lzy.servlet;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/***
 * @zhouyuting
 * @date 2023/9/15 11:20
 */
@Configuration
public class ServletConfig {
    @Bean
    public ServletRegistrationBean getServlet(MyServlet myServlet){
        ServletRegistrationBean registrationBean =
                new ServletRegistrationBean(myServlet,"/myServlet");
        return registrationBean;
    }
}
