package cn.edu.hfut.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @RequestMapping(value = "/detail")
    public String UserDetail(Model model) {

        model.addAttribute("data","hello thymeleaf!");
        return "detail";
    }

    @RequestMapping(value = "/add")
    public @ResponseBody Object AddUser() {
        return "/add请求";
    }
}
