package com.lgs.算法;

/**
 * @Auther: lgs
 * @Date: 2018-11-21 14:06
 * @Description:
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] a = {0,1,4,11,10,8,9,3};
        HeapSort sort = new HeapSort();
        sort.sort(a);
        for(int i : a) {
            System.out.print(i+ " ");
        }
    }

    public void sort(int[] nums) {
        //建堆
        for(int i = nums.length/2; i > 0; i--) {
            sink(nums, i, nums.length-1);
        }
        //堆排序
        int t = nums.length-1;
        while(t > 0) {
            swap(nums, 1, t);
            t--;
            for(int i = 1; i < t; i++) {
                sink(nums, i, t);
            }

        }
    }

    public void sink(int[] nums, int i,int t) {
        while(2 * i <= t) {
            int k = 2*i;
            if(k+1 <= t) {
                if(nums[k] < nums[k+1]) {
                    k = k+1;
                }
            }
            if(nums[i] >= nums[k]) {
                break;
            }
            swap(nums, i, k);
            i = k;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
