package cn.edu.hfut.springboot.controller;

import cn.edu.hfut.springboot.service.StudentCountService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Reference(interfaceClass = StudentCountService.class,version = "1.0.0",check = false)
    private StudentCountService studentCountService;

    @RequestMapping("/student/count")
    public String studentCount() {
        String res = studentCountService.getStudentCount();
        return "学生数量为"+res;
    }
}
