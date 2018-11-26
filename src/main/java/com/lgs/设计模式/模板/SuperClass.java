package com.lgs.设计模式.模板;

/**
 * @Auther: lgs
 * @Date: 2018-11-13 08:45
 * @Description:
 */
public abstract class SuperClass {
    private void addWater() {
        System.out.println("water");
    }

    private void addCloth() {
        System.out.println("cloth");
    }

    public void beforeCook(){}

    protected abstract void cook();

    public final void doCook() {
        this.addCloth();
        this.addWater();
        this.cook();
    }
}
