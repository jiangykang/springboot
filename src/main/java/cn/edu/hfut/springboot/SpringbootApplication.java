package cn.edu.hfut.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //开启spring配置
@MapperScan(basePackages = "cn.edu.hfut.springboot.mapper")  //开启扫描mapper接口的包以及子目录
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

}
