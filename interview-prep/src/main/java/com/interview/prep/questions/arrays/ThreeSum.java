package com.interview.prep.questions.arrays;

//Leetcode_15   //TODO
//Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
//
//Notice that the solution set must not contain duplicate triplets.
//
//
//
//Example 1:
//
//Input: nums = [-1,0,1,2,-1,-4]
//Output: [[-1,-1,2],[-1,0,1]]
//Explanation:
//nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
//nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
//nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
//The distinct triplets are [-1,0,1] and [-1,-1,2].
//Notice that the order of the output and the order of the triplets does not matter.
//Example 2:
//
//Input: nums = [0,1,1]
//Output: []
//Explanation: The only possible triplet does not sum up to 0.
//Example 3:
//
//Input: nums = [0,0,0]
//Output: [[0,0,0]]
//Explanation: The only possible triplet sums up to 0.
//
//
//Constraints:
//
//        3 <= nums.length <= 3000
//        -105 <= nums[i] <= 105

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Math.abs;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Boolean> oppositeExistMap = new HashMap<>();
        for (int num : nums) {
            if(map.containsKey(-num) && !oppositeExistMap.containsKey(-num)){
                oppositeExistMap.put(num, true);
            }

            if (map.containsKey(0) && num != 0 && map.containsKey(-num) && !map.containsKey(num)){
                output.add(List.of(0, num, -num));
                oppositeExistMap.remove(num);
                oppositeExistMap.remove(-num);
            }
            else if(num != 0 && map.containsKey(num) && map.containsKey(-2*num))
                output.add(List.of(num, num, -2*num));
            else if(num !=0 && num%2 == 0 && map.containsKey(-num/2) && map.get(-num/2) > 1)
                output.add(List.of(num, -num/2, -num/2));

            if (map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);

        }
        if(map.containsKey(0) && map.get(0) >= 3 ) {
            output.add(List.of(0,0,0));
        } else if (map.containsKey(0) && !oppositeExistMap.isEmpty()) {
            for(int entryKey : oppositeExistMap.keySet()){
                output.add(List.of(entryKey, -entryKey, 0));
            }
        }
        return output;
    }

    public static void main(String[] args) {

//        System.out.println(threeSum(new int[]{-1,1,0})); // Output: [[0, 1, -1]]
        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4})); // Output: [[-1,-1,2],[-1,0,1]]
        System.out.println(threeSum(new int[]{0,1,1})); // Output: []
        System.out.println(threeSum(new int[]{0,0,0})); // Output: [[0,0,0]]
    }
}
