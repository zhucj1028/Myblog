package cn.xiaolimoon.blog.master.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Zcj
 */
@Controller
public class SystemController {

    @GetMapping("/index.html")
    public String index() {
        return "index";
    }

    @GetMapping("/login.html")
    public String login() {
        return "login";
    }

    @GetMapping("/register.html")
    public String register() {
        return "register";
    }


    // 适用于使用@RestController时
    // public ModelAndView login() {
    //    return new ModelAndView("login");
    // }
}
