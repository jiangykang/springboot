package cn.edu.hfut.springboot.service.impl;

import cn.edu.hfut.springboot.mapper.StudentMapper;
import cn.edu.hfut.springboot.model.Student;
import cn.edu.hfut.springboot.service.StudentService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@Service(interfaceClass = StudentService.class,version = "1.0.0",timeout = 15000)
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;


    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public int insertStu(Student student) {
        int i = studentMapper.insertSelective(student);
        redisTemplate.opsForValue().set(student.getId(),student);
        Student student1 = (Student)redisTemplate.opsForValue().get(student.getId());
        System.out.println(student1.getName());
        return i;
    }

    @Override
    public Student qryStudentById(Integer id) {
        Student student = studentMapper.selectByPrimaryKey(id);
        return student;
    }

    @Override
    public Integer queryAllStudentCount() {
        //先从redis获取
        Integer allStudentCount = (Integer)redisTemplate.opsForValue().get("allStudentCount");
        if (allStudentCount != null) {
            System.out.println("从redis获取学生数量成功");
        }
        else {
            System.out.println("从redis获取学生数量失败，查询数据库获取学生数量");
            allStudentCount = studentMapper.queryAllCount();
            redisTemplate.opsForValue().set("allStudentCount",allStudentCount,15, TimeUnit.SECONDS);
            System.out.println("学生数量已写入redis");
        }
        return allStudentCount;
    }
}
