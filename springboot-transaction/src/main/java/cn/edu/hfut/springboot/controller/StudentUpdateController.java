package cn.edu.hfut.springboot.controller;

import cn.edu.hfut.springboot.model.Student;
import cn.edu.hfut.springboot.service.StudentUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentUpdateController {

    @Autowired
    private StudentUpdateService studentUpdateService;

    @RequestMapping(value = "/update")
    public @ResponseBody String updateStudent(Integer id, String name) {

        Student student = new Student();
        student.setId(id);
        student.setName(name);
        int i = studentUpdateService.updateStudentById(student);
        return "修改id="+id+"的学生信息，修改结果为"+i;

    }
}
