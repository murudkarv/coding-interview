package com.interview.prep.questions.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Leetcode_347
//Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
//
//
//
//        Example 1:
//
//Input: nums = [1,1,1,2,2,3], k = 2
//Output: [1,2]
//Example 2:
//
//Input: nums = [1], k = 1
//Output: [1]
//
//
//Constraints:
//
//        1 <= nums.length <= 105
//        -104 <= nums[i] <= 104
//k is in the range [1, the number of unique elements in the array].
//It is guaranteed that the answer is unique.
//
//
//Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        List<Integer>[] numFrequency = new ArrayList[nums.length + 1];

        for(int i = 0 ; i < numFrequency.length; i++){
            numFrequency[i] = new ArrayList<>();
        }

        for(int i : nums){
            countMap.put(i, countMap.getOrDefault(i, 0) + 1);
        }

        for(Map.Entry entry : countMap.entrySet()){
            numFrequency[(int) entry.getValue()].add((Integer) entry.getKey());
        }

        int[] output = new int[k];
        int index = 0;
        for(int j =  numFrequency.length - 1; index < k && j > 0; j--){
            for(int n : numFrequency[j]){
                output[index++] = n;
                if(index == k) {
                    return output;
                }
            }
        }
        return output;
    }
}
