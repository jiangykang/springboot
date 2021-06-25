package cn.edu.hfut.springboot.service.impl;

import cn.edu.hfut.springboot.mapper.StudentMapper;
import cn.edu.hfut.springboot.model.Student;
import cn.edu.hfut.springboot.service.StudentUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentUpdateServiceImpl implements StudentUpdateService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    @Transactional
    public int updateStudentById(Student student) {
        int i = studentMapper.updateByPrimaryKeySelective(student);

        int j = 10/0;
        return i;
    }
}
