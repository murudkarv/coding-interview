package com.interview.prep.questions.arrays;

import java.util.*;
import java.util.stream.Collectors;

//Leetcode_2300 - TODO
//You are given two positive integer arrays spells and potions, of length n and m respectively, where spells[i] represents the strength of the ith spell and potions[j] represents the strength of the jth potion.
//
//You are also given an integer success. A spell and potion pair is considered successful if the product of their strengths is at least success.
//
//Return an integer array pairs of length n where pairs[i] is the number of potions that will form a successful pair with the ith spell.
//
//
//
//Example 1:
//
//Input: spells = [5,1,3], potions = [1,2,3,4,5], success = 7
//Output: [4,0,3]
//Explanation:
//- 0th spell: 5 * [1,2,3,4,5] = [5,10,15,20,25]. 4 pairs are successful.
//- 1st spell: 1 * [1,2,3,4,5] = [1,2,3,4,5]. 0 pairs are successful.
//- 2nd spell: 3 * [1,2,3,4,5] = [3,6,9,12,15]. 3 pairs are successful.
//        Thus, [4,0,3] is returned.
//Example 2:
//
//Input: spells = [3,1,2], potions = [8,5,8], success = 16
//Output: [2,0,2]
//Explanation:
//        - 0th spell: 3 * [8,5,8] = [24,15,24]. 2 pairs are successful.
//- 1st spell: 1 * [8,5,8] = [8,5,8]. 0 pairs are successful.
//- 2nd spell: 2 * [8,5,8] = [16,10,16]. 2 pairs are successful.
//        Thus, [2,0,2] is returned.
//
//
//Constraints:
//
//n == spells.length
//m == potions.length
//1 <= n, m <= 105
//1 <= spells[i], potions[i] <= 105
//1 <= success <= 1010
public class SpellsAndPotionsSuccess {
    //O(n) -> count sort + two pointer
    public static int[] successfulPairsUsingTwoPointer(int[] spells, int[] potions, long success) {
        int[] output = Arrays.copyOf(spells, spells.length);
        Map<Integer, Integer> spellsNoOfSuccess = new HashMap<>();
        counterSort(potions);
        counterSort(spells);

        int i = potions.length - 1;
        int j = i;

        for (int k = 0; k < spells.length; k++) {

            while (j >= 0 && (long) potions[j] * spells[k] >= success) {
                j--;
            }
            //Adding spells and its success count in a map
            if (i == j)
                spellsNoOfSuccess.put(spells[k], 0);
            else {
                spellsNoOfSuccess.put(spells[k], i - j);
                i = j + 1;
            }
        }
        for(int a = 0; a < output.length; a++){
            output[a] = spellsNoOfSuccess.get(output[a]);
        }
        return output;
    }





    //O(n logn)  -> merge sort + binary search
    public static int[] successfulPairsUsingBinarySearch(int[] spells, int[] potions, long success) {
        int[] output = new int[spells.length];
        mergeSort(potions);

        for(int i = 0 ; i < spells.length ; i++){
            int lowPotions = 0, highPotions = potions.length - 1, mid = 0;
            while(lowPotions <= highPotions) {
                mid = lowPotions + (highPotions - lowPotions) / 2;
                if((long) spells[i]*potions[mid] >= success){
                    lowPotions = mid + 1;
                }else if((long) spells[i]*potions[mid] < success){
                    highPotions = mid - 1;
                }
            }
            output[i] = lowPotions;
        }
        return output;
    }
    public static void counterSort(int[] arr){
        if (arr.length == 0) return;

        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();
        int range = max - min + 1;

        int[] count = new int[range];

        // Step 1: Count occurrences
        for (int num : arr) {
            count[num - min]++;
        }

        // Step 2: Write sorted values back into arr
        int index = 0;
        for (int i = 0; i < range; i++) {
            while (count[i]-- > 0) {
                arr[index++] = i + min;
            }
        }
    }

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) return;

        int mid = left + (right - left) / 2;

        // Sort left and right halves
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        // Merge the sorted halves
        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        // Create temp arrays
        int[] leftArr = Arrays.copyOfRange(arr, left, mid + 1);
        int[] rightArr = Arrays.copyOfRange(arr, mid + 1, right + 1);

        int i = 0, j = 0, k = left;

        // Merge back into original array
        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] >= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }

        // Copy any remaining elements
        while (i < leftArr.length) arr[k++] = leftArr[i++];
        while (j < rightArr.length) arr[k++] = rightArr[j++];
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(successfulPairsUsingBinarySearch(new int[]{15, 8, 19}, new int[]{38, 36, 23}, 328))); // Output: 0
        System.out.println(Arrays.toString(successfulPairsUsingTwoPointer(new int[]{15, 8, 19}, new int[]{38, 36, 23}, 328)));
//        System.out.println(firstUniqueCharacter("concussion")); // Output: 4
//        System.out.println(firstUniqueCharacter("aabbcc"));      // Output: -1
    }
}
