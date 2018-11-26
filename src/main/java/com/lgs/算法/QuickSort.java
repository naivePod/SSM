package com.lgs.算法;

/**
 * @Auther: lgs
 * @Date: 2018-11-21 09:25
 * @Description:
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] a = {4,1,2,4,7,8,9,0};
        QuickSort sort = new QuickSort();
        sort.solve(a, 0, a.length-1);
        for(int i : a) {
            System.out.print(i+ " ");
        }
    }

    public void solve(int[]num, int l, int r) {
        if(l >= r) return;
        int p = getPosition(num, l, r);
        solve(num, l, p-1);
        solve(num, p+1, r);
    }

    public int getPosition(int[] num, int l, int r) {
        int li = l;
        int lo = r+1;
        int temp = num[l];
        while(li < lo) {
            while( num[++li] < temp &&li!=r ) ;
            while(num[--lo] > temp && lo!=l) ;
            if(li >= lo) break;
            swap(li, lo, num);
        }
        swap(lo,l, num);

        return lo;
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
