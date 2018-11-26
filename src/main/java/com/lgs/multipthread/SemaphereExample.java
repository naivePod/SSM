package com.lgs.multipthread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @Auther: lgs
 * @Date: 2018-11-20 10:14
 * @Description:
 */
public class SemaphereExample {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        final Semaphore a = new Semaphore(1);
        final Semaphore b = new Semaphore(1);
        final Semaphore c = new Semaphore(1);
        service.submit(new Runnable() {
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
        });
        service.submit(new Runnable() {
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
                    a.release();

                }
            }
        });
        b.acquire();
        service.shutdown();
    }
}
