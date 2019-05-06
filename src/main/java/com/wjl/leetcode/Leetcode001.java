package com.wjl.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 *  两数之和
 *
 * 给定一个整数数组 nums 和一个目标值 target，
 * 请你在该数组中找出和为目标值的那 两个 整数，
 * 并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。
 * 但是，你不能重复利用这个数组中同样的元素。
 * 示例:  给定 nums = [2, 7, 11, 15], target = 9
 * 因为  nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回     [0, 1]
 *
 * @author wangJiaLun
 * @date 2019-05-06
 **/
public class Leetcode001 {

    /**
     *  数组遍历两次计算
     *   时间复杂度 O(n²)
     *   空间复杂度 O(1)
     * @param nums  整数数组
     * @param target 目标值
     * @return 数组中和为目标值的两个整数的下标
     */
    public int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1 ; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     *  两遍哈希表
     *  时间复杂度 O(n)
     *  空间复杂度 O(n)
     * @param nums  整数数组
     * @param target 目标值
     * @return 数组中和为目标值的两个整数的下标
     */
    public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int result = target - nums[i];
            if (map.containsKey(result) && i != map.get(result)) {
                return new int[] {i, map.get(result)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
    /**
     *  一遍哈希表
     *  时间复杂度 O(n)
     *  空间复杂度 O(n)
     * @param nums  整数数组
     * @param target 目标值
     * @return 数组中和为目标值的两个整数的下标
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int result = target -nums[i];
            if (map.containsKey(result)) {
                return new int[] {map.get(result), i};
            }
            map.put(nums[i], i);
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
