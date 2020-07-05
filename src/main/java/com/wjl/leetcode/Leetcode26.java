package com.wjl.leetcode;

/**
 * @author wangJiaLun
 * @date 2020-07-05
 **/
public class Leetcode26 {

    /**
     *  题目提示有序，重复元素必定相邻
     *  用两个指针代表相邻元素
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int i = 0;
        int j = i + 1;
        while(j < nums.length){
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
            j++;
        }
        return i+1;
    }
}
