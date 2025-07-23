package com.interview.prep.questions.arrays;

import java.util.Arrays;

//Leetcode_238
//Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
//
//The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
//
//You must write an algorithm that runs in O(n) time and without using the division operation.
//
//
//
//Example 1:
//
//Input: nums = [1,2,3,4]
//Output: [24,12,8,6]
//Example 2:
//
//Input: nums = [-1,1,0,-3,3]
//Output: [0,0,9,0,0]
//
//
//Constraints:
//
//        2 <= nums.length <= 105
//        -30 <= nums[i] <= 30
//The input is generated such that answer[i] is guaranteed to fit in a 32-bit integer.
//
//
//Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)
public class ProductArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        int product = 1;
        int zeroCount = 0;
        for(int n : nums){
            if(n == 0)
                zeroCount++;
            else
                product = product * n;
        }
        for(int i = 0; i < answer.length; i++){
            if(zeroCount > 1 || (zeroCount == 1 && nums[i] != 0))
                answer[i] = 0;
            else if(zeroCount == 1 && nums[i] == 0)
                answer[i] = product;
            else
                answer[i] = product/nums[i];
        }
        return answer;
    }

    public static void main(String[] args){
        System.out.println(Arrays.toString(productExceptSelf(new int[]{-1, 1, 0, -3, 3})));
    }
}
