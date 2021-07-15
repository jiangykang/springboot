package cn.edu.hfut.springboot;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "cn.edu.hfut.springboot.mapper")
@SpringBootApplication
@EnableDubboConfiguration
public class SpringbootSsmProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSsmProviderApplication.class, args);
    }

}
