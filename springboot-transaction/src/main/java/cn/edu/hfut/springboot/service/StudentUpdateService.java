package cn.edu.hfut.springboot.service;

import cn.edu.hfut.springboot.model.Student;

public interface StudentUpdateService {
    /**
     * 修改学生信息
     * @return
     */
    int updateStudentById(Student student);
}
