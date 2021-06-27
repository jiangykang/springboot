package cn.edu.hfut.springboot.controller;

import cn.edu.hfut.springboot.service.RedisPutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    private RedisPutService redisPutService;

    @RequestMapping("/put")
    public String put() {


        redisPutService.put("name","jiang");
        return "存入redis成功";
    }
}
