package com.lgs.multipthread;

import java.util.concurrent.Semaphore;

/**
 * @Auther: lgs
 * @Date: 2018-11-19 17:22
 * @Description:
 */
public class Bootstrap {
    static final String a = "aaa";
    static final String b = "a";
    static final String c = "aa";
    static {

        System.out.println("aaa" == b+c);
    }
    public static void main(String[] args) throws InterruptedException {
//        Semaphore a = new Semaphore(1);
//        Semaphore b = new Semaphore(1);
//        Semaphore c = new Semaphore(1);
//
//        SamphereThread thread = new SamphereThread(a, b, c);
//
//        Thread thread1 = new Thread(thread.sayA());
//        Thread thread2 = new Thread(thread.sayB());
//        Thread thread3 = new Thread(thread.sayC());
//        b.acquire();c.acquire();
//        thread1.start();
//        thread2.start();
//        thread3.start();
    }


}
