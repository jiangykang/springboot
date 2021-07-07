package cn.edu.hfut.springboot.service.impl;

import cn.edu.hfut.springboot.mapper.StudentMapper;
import cn.edu.hfut.springboot.model.Student;
import cn.edu.hfut.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public Student queryStudentDetail(Integer id) {
//        RedisSerializer stringSerializer = new StringRedisSerializer();//序列化为String
//        //不能反序列化
//        //Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);//序列化为Json
//        GenericJackson2JsonRedisSerializer serializer = new GenericJackson2JsonRedisSerializer();
//        redisTemplate.setKeySerializer(stringSerializer);
//        redisTemplate.setValueSerializer(serializer);
//        redisTemplate.setHashKeySerializer(stringSerializer);
//        redisTemplate.setHashValueSerializer(serializer);
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
