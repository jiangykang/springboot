package cn.edu.hfut.springboot;

import cn.edu.hfut.springboot.config.StudentConfig;
import cn.edu.hfut.springboot.model.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
@ServletComponentScan(basePackages = "cn.edu.hfut.springboot.servlet")
public class SpringbootServletApplication {

    public static void main(String[] args) {
//        AbstractApplicationContext abstractApplicationContext = new AnnotationConfigApplicationContext(StudentConfig.class);
//        Student student = (Student) abstractApplicationContext.getBean("stu1");
//        System.out.println(student);
        SpringApplication.run(SpringbootServletApplication.class, args);
//        String path = "spring.xml";
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(path);
//        Student student = (Student) applicationContext.getBean("stu2");
//        System.out.println(student);
    }

}
