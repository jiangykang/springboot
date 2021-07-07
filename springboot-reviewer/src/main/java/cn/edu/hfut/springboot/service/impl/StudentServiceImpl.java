package cn.edu.hfut.springboot.service.impl;

import cn.edu.hfut.springboot.mapper.StudentMapper;
import cn.edu.hfut.springboot.model.Student;
import cn.edu.hfut.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public Student queryStudentDetail(Integer id) {
        Student student = (Student) redisTemplate.opsForValue().get("stu");
        if (student != null) {
            System.out.println("-----------------------从redis获取缓存成功");
            return student;
        }
        student = studentMapper.selectByPrimaryKey(id);
        redisTemplate.opsForValue().set("stu",student,1500);
        Student student1 = (Student) redisTemplate.opsForValue().get("stu");
        System.out.println(student1);
        System.out.println("-----------------------从redis获取缓存失败，从数据库读取并缓存到redis");
        return student;
    }
}
