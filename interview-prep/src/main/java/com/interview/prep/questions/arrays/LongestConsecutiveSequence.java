package com.interview.prep.questions.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Leetcode_128
//Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
//
//You must write an algorithm that runs in O(n) time.
//
//
//
//Example 1:
//
//Input: nums = [100,4,200,1,3,2]
//Output: 4
//Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
//Example 2:
//
//Input: nums = [0,3,7,2,5,8,4,6,0,1]
//Output: 9
//Example 3:
//
//Input: nums = [1,0,1,2]
//Output: 3
//
//
//Constraints:
//
//        0 <= nums.length <= 105
//        -109 <= nums[i] <= 109
public class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] nums) {
        // number and its sequence length, at any given end of iteration only boundaries of sequence and current number will have accurate length
        Map<Integer, Integer> map = new HashMap<>();
        int output = 0;
        for(int num : nums){
            if(!map.containsKey(num)){
                // length = length of left + length of right + 1(due to num itself)
                map.put(num, map.getOrDefault(num - 1, 0) + map.getOrDefault(num + 1, 0) + 1);
                // update left most boundary with latest length of the sequence
                map.put(num - map.getOrDefault(num - 1, 0), map.get(num));
                //update right most boundary with latest length of the sequence
                map.put(num + map.getOrDefault(num + 1, 0), map.get(num));
                output = Math.max(output, map.get(num));
            }
        }
        return output;
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{100,4,200,1,3,2})); // Output: 4
        System.out.println(longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1})); // output: 9
    }
}

