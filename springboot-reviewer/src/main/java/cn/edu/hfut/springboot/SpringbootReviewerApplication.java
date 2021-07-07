package cn.edu.hfut.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "cn.edu.hfut.springboot.mapper")
public class SpringbootReviewerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootReviewerApplication.class, args);
    }

}
