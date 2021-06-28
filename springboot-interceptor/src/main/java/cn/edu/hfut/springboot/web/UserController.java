package cn.edu.hfut.springboot.web;

import cn.edu.hfut.springboot.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @RequestMapping(value = "/login")
    public @ResponseBody Object login(HttpServletRequest request) {
        //将用户的信息存到session中
        User user = new User();
        user.setId(1001);
        user.setUsername("zhangsan");
        request.getSession().setAttribute("user",user);
        return "login Success";
    }

    //该请求需要用户登录才能访问
    @RequestMapping(value = "/center")
    public @ResponseBody Object center() {
        return "See center message";
    }


    //该请求不登录也可访问
    @RequestMapping(value = "/error")
    public @ResponseBody Object out() {
        return "error";
    }
}
