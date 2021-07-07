package cn.edu.hfut.springboot.config;

import cn.edu.hfut.springboot.model.Student;
import cn.edu.hfut.springboot.servlet.MyServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //该注解将此类定义为配置类（相当于xml配置文件）
public class ServletConfig {
    //@Bean是一个方法级别的注解，主要用于配置类里
    // 相当于一个
    // <beans>
    //   <bean id="" class="">
    // </beans>
    @Bean("servlet")
    public ServletRegistrationBean myServletRegistrationBean() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new MyServlet());
        servletRegistrationBean.addUrlMappings("/myServlet2");
        return servletRegistrationBean;
    }


}
