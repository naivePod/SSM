package com.lgs.multipthread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: lgs
 * @Date: 2018-11-20 10:29
 * @Description:
 */
public class Demo {
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    Condition condition1 = lock.newCondition();

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Class a = CountDownThread.class;
        CountDownThread countDownThread = (CountDownThread) a.newInstance();
    }
}
