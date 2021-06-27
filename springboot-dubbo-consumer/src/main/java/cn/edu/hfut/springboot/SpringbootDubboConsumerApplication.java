package cn.edu.hfut.springboot;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubboConfig;
import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //开启spring注解配置
@EnableDubboConfiguration  //开启dubbo配置
public class SpringbootDubboConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDubboConsumerApplication.class, args);
    }

}
