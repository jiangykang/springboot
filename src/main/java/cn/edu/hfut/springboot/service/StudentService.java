package cn.edu.hfut.springboot.service;

import cn.edu.hfut.springboot.model.Student;
import org.springframework.stereotype.Service;

public interface StudentService {

    /**
     * 根据id查询学生详情
     * @param id
     * @return
     */
    Student qryStudentById(Integer id);
}
