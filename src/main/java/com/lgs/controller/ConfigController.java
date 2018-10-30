package com.lgs.controller;

import com.lgs.beans.ResultBean;
import com.lgs.service.IHelloService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/config/")
@Controller
public class ConfigController {
    @Autowired
    IHelloService iHelloService;

    @RequestMapping(value = "say")
    public ResultBean<Boolean> sayHello() {
        return new ResultBean<>(iHelloService.sayAfterReturning());
    }
}
