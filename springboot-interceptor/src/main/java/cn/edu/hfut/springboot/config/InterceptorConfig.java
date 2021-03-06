package cn.edu.hfut.springboot.config;

import cn.edu.hfut.springboot.interceptor.UserInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration  //定义此类为配置类（即相当于xml配置文件）
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        String[] addPathPatterns = {
                "/user/**"

        };
        String[] excludePathPatterns = {
                "/user/login",
                "/user/error"

        };
        registry.addInterceptor(new UserInterceptor()).addPathPatterns(addPathPatterns).excludePathPatterns(excludePathPatterns);
    }
}
