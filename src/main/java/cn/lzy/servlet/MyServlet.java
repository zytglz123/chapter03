package cn.lzy.servlet;

import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        this.doPost(req, resp); }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException,IOException {
        resp.getWriter().write("hello Myservlet");
    }
    @Bean
    public ServletListenerRegistrationBean getServletListener(MyListener myListener){
        ServletListenerRegistrationBean registrationBean =
                new ServletListenerRegistrationBean(myListener);
        return registrationBean;
    }
}
