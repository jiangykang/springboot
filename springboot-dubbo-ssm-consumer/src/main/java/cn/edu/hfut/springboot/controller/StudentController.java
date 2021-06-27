package cn.edu.hfut.springboot.controller;

import cn.edu.hfut.springboot.model.Student;
import cn.edu.hfut.springboot.service.StudentService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController {

    @Reference(interfaceClass = StudentService.class,version = "1.0.0",check = false)
    private StudentService studentService;

    @RequestMapping(value = "/insertStudent")
    public @ResponseBody Object insertStudent(Integer id, String name) {

        Student student = new Student();
        student.setId(id);
        student.setName(name);
        int i = studentService.insertStu(student);
        return "新建学生信息成功！";
    }

    @RequestMapping(value = "/studentDetail/{id}")
    public String studentDetail(Model model, @PathVariable Integer id) {
        Student student = studentService.qryStudentById(id);
        model.addAttribute("student",student);
        return "studentDetail";
    }

    @RequestMapping(value = "/student/all/count")
    public @ResponseBody Object allStudentCount() {

        Integer allStudentCount = studentService.queryAllStudentCount();
        return "学生数量为："+allStudentCount;
    }
}
