package cn.edu.hfut.springboot.controller;

import cn.edu.hfut.springboot.model.Student;
import cn.edu.hfut.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/student")
    @ResponseBody
    public Student student(Integer id) {

        Student student = studentService.qryStudentById(id);
        return student;
    }
}
