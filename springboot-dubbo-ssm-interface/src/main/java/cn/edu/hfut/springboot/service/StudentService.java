package cn.edu.hfut.springboot.service;

import cn.edu.hfut.springboot.model.Student;

public interface StudentService {
    int insertStu(Student student);

    Student qryStudentById(Integer id);

    Integer queryAllStudentCount();

}
