package com.interview.prep.questions.arrays;

import java.util.HashMap;
import java.util.Map;

//Leetcode_1
//Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
//
//You may assume that each input would have exactly one solution, and you may not use the same element twice.
//
//You can return the answer in any order.
//
//
//
//        Example 1:
//
//Input: nums = [2,7,11,15], target = 9
//Output: [0,1]
//Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
//Example 2:
//
//Input: nums = [3,2,4], target = 6
//Output: [1,2]
//Example 3:
//
//Input: nums = [3,3], target = 6
//Output: [0,1]
//
//
//Constraints:
//
//        2 <= nums.length <= 104
//        -109 <= nums[i] <= 109
//        -109 <= target <= 109
//Only one valid answer exists.
//
//
//        Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?
public class TwoSum {

    //Brute force TC - O(n^2)
    public int[] twoSum(int[] nums, int target) {
        int size = nums.length;
        for(int i = 0; i < size ; i++){
            for(int j = i + 1; j < size; j++){
                if(nums[i] + nums[j] == target) {
                    int[] arr = {i, j};
                    return arr;
                }
            }
        }
        return null;
    }

    //Brute force TC - O(n)
    public int[] twoSumEfficient(int[] nums, int target) {
        int size = nums.length;
        Map<Integer, Integer> indexMap = new HashMap<>();
        for(int i = 0; i < size ; i++){
            if(null != indexMap.get(target - nums[i])){
                return new int[]{indexMap.get(target - nums[i]), i};
            }
            indexMap.put(nums[i], i);
        }
        return null;
    }

}
