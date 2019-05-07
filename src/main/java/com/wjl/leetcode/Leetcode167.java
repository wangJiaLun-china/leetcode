package com.wjl.leetcode;

/**
 * 两数之和 II - 输入有序数组
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * 说明:
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 示例:
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 *
 * @author wangJiaLun
 * @date 2019-05-06
 **/
public class Leetcode167 {

    /**
     *  双向遍历法
     *   时间复杂度 O(n)
     *   空间复杂度 O(1)
     * @param nums  有序整数数组
     * @param target 目标值
     * @return 数组中和为目标值的两个整数的下标
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int start=0;
            int end=nums.length-1;
            int tmpTarget=nums[start]+nums[end];
            while(tmpTarget != target && start<end){
                if(tmpTarget > target){
                    end--;
                }else{
                    start++;
                }
                tmpTarget=nums[start]+nums[end];
            }
            return new int[]{start+1,end+1};
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 13;
        Leetcode001 instance = new Leetcode001();
        int[] result = instance.twoSum1(nums, target);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
