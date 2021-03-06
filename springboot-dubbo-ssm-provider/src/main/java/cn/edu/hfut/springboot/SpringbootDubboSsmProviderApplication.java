package cn.edu.hfut.springboot;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubboConfiguration
@MapperScan(basePackages = "cn.edu.hfut.springboot.mapper")
public class SpringbootDubboSsmProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDubboSsmProviderApplication.class, args);
    }

}
