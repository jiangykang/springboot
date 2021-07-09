package cn.edu.hfut.springboot.service.impl;

import cn.edu.hfut.springboot.mapper.StudentMapper;
import cn.edu.hfut.springboot.model.Student;
import cn.edu.hfut.springboot.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public Student queryStudentDetail(Integer id) {

        log.info("这是我打印的log");
        log.error("这是错误log");
        Student student = (Student) redisTemplate.opsForValue().get("stu");
        if (student != null) {
            System.out.println("-----------------------从redis获取缓存成功");
            return student;
        }
        student = studentMapper.selectByPrimaryKey(id);
        redisTemplate.opsForValue().set("stu",student,1500, TimeUnit.SECONDS);
        Student student1 = (Student) redisTemplate.opsForValue().get("stu");
        System.out.println(student1);
        System.out.println("-----------------------从redis获取缓存失败，从数据库读取并缓存到redis");
        return student;
    }
}
