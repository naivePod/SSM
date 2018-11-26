package com.lgs.设计模式.模板;

/**
 * @Auther: lgs
 * @Date: 2018-11-13 08:50
 * @Description:
 */
public class BaseClass extends SuperClass {
    @Override
    protected void cook() {
        System.out.println("baseclass cook");
    }

    @Override
    public void beforeCook() {
        super.beforeCook();
    }
}
