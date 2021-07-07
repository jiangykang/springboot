package cn.edu.hfut.springboot.config;

import cn.edu.hfut.springboot.model.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
    @Bean("stu1")
    public Student mystudent() {
        Student student = new Student(1,"11");
        student.setId(111);
        student.setName("jiang");
        return student;
    }
}
