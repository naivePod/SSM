package com.lgs.controller;

import com.lgs.pojo.User;
import com.lgs.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Auther: lgs
 * @Date: 2018-10-30 09:59
 * @Description:
 */

@Controller
@RequestMapping("")
public class UserController {
    @Autowired
    private IUserService iUserService;

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(value = "/loginAdmin",method = RequestMethod.POST)
    public String login(User user, Model model) {
        logger.info("user:{} {}", user.getUserName(), user.getPassword());
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getPassword());
        try {
            subject.login(token);
            return "admin";
        } catch (Exception e) {
            model.addAttribute("error", "用户名或密码错误");
            return "../../login";
        }
    }

    @RequestMapping("/admin")
    public String admin(){
        return "admin";
    }
    @RequestMapping("/student")
    public String student(){
        return "admin" ;
    }
    @RequestMapping("/teacher")
    public String teacher(){
        return "admin" ;
    }
}
