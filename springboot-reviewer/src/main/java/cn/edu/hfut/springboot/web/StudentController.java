package cn.edu.hfut.springboot.web;

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

    @RequestMapping(value = "/student/detail")
    public @ResponseBody Object studentDetail(Integer id) {

        Student student = studentService.queryStudentDetail(id);
        return student;
    }
}
