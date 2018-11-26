package com.lgs.multipthread;

import java.util.concurrent.Semaphore;

/**
 * @Auther: lgs
 * @Date: 2018-11-19 17:11
 * @Description:
 */
public class SamphereThread  {
    Semaphore a;
    Semaphore b;
    Semaphore c;

    public SamphereThread(Semaphore a, Semaphore b, Semaphore c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Runnable sayA() {
        return new Runnable() {
            @Override
            public void run() {
                int i = 10;
                while(i >= 0) {
                    try {
                        a.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("A");
                    i--;
                    b.release();
                }
            }
        };
    }

    public Runnable sayB() {
        return new Runnable() {
            @Override
            public void run() {
                int i = 10;
                while(i >= 0) {
                    try {
                        b.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    i--;
                    System.out.println("B");
                    c.release();

                }
            }
        };
    }

    public Runnable sayC() {
        return new Runnable() {
            @Override
            public void run() {
                int i = 10;

                while(i >= 0) {
                    try {
                        c.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("C");
                    i--;
                    a.release();

                }
            }
        };
    }
}
