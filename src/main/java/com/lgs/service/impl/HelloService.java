package com.lgs.service.impl;

import com.lgs.service.IHelloService;
import org.springframework.stereotype.Service;

@Service
public class HelloService implements IHelloService {
    public void sayHello(String name, Integer count) {
        System.out.println("name:" + name + " pay:"+ count);
    }

    public boolean sayAfterReturning() {
        System.out.println("===========sayAfter");
        return true;
    }
}
