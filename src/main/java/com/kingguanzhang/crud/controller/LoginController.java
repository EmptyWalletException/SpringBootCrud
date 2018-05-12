package com.kingguanzhang.crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;


@Controller
public class LoginController {

    @PostMapping("/user/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Map<String, Object> map, HttpSession session){
        if( StringUtils.isEmpty(username) || StringUtils.isEmpty(password)){
            map.put("msg","用户名或密码错误");
            return "login";
        }
        //在session中放入一个值以配合登录拦截器检查;
        session.setAttribute("loginUser",username);
        //重定向到另一个页面,防止刷新时重复提交表单;需要配合拦截器进行登录检查;
        return "redirect:/loginRedirect";
    }
}
