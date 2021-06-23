package cn.edu.hfut.springboot.controller;

import cn.edu.hfut.springboot.config.PersonConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class helloController {

    @Autowired
    private PersonConfig personConfig;

    @Value("${name}")
    String name;

    @Value("${age}")
    int age;
    @RequestMapping("/hello")
    @ResponseBody
    public  String sayHello() {
        return personConfig.toString();
    }

    @RequestMapping("/say")
    public ModelAndView say() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("hello","你好，我是jsp");
        modelAndView.setViewName("say");
        return modelAndView;
    }

    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("hello","我是model");
        return "say";
    }
}
