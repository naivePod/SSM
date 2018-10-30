package com.lgs.AOP;

public class HelloAspect {
    public void beforeAdvice(String name, Integer count) {
        System.out.println("before  name:" + name + "count:" + count);
    }

    public void afterReturningAdvice(Object retVal) {
        System.out.println("============after returning retVal" + retVal);
    }
}
