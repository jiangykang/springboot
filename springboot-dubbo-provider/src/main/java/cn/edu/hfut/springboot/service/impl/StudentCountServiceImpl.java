package cn.edu.hfut.springboot.service.impl;

import cn.edu.hfut.springboot.service.StudentCountService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

@Component
@Service(interfaceClass = StudentCountService.class,version = "1.0.0",timeout = 15000)
public class StudentCountServiceImpl implements StudentCountService {
    @Override
    public String getStudentCount() {
        return "150";
    }
}
