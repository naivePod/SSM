package com.lgs.算法;

import java.lang.ref.WeakReference;

/**
 * @Auther: lgs
 * @Date: 2018-11-23 09:21
 * @Description:
 */
public class Search {
    public static void main(String[] args) {
//        int[] a = {0,1,4,11,10,8,9,3,-5};
//        long time1 = System.currentTimeMillis();
//        re(a, 0, a.length-1);
//        long time2 = System.currentTimeMillis();
//        System.out.println((time2-time1));
//        for(int i : a) {
//            System.out.print(i+ " ");
//        }
        Object obj = new Object();
        WeakReference<Object> reference = new WeakReference<>(obj);
        System.out.println(reference.get());;
        obj = null;
        System.gc();
        System.out.println(reference.get());;

    }

    public static void re(int[] a, int l, int r) {
        if(l >= r) return;
        int mid = l + (r-l)/2;
        re(a, l, mid);
        re(a, mid+1, r);
        sort(a, l, mid, r);
    }

    public static void sort(int[] a, int l, int m, int h) {
        int i = l;
        int j = m+1;
        int[] temp = new int[a.length];

        for(int k = i; k <= h; k++) {
            temp[k] = a[k];
        }

        for(int k = l; k <= h; k++) {
            if(i > m) {
                a[k] = temp[j++];
            } else if(j > h) {
                a[k] = temp[i++];
            } else if(temp[i] < temp[j]) {
                a[k] = temp[i++];
            } else {
                a[k] = temp[j++];
            }
        }
    }

}
