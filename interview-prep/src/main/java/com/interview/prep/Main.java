package com.interview.prep;

import com.interview.prep.sorting.SortingAlgorithms;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {4, 1, 3, 9, 7};
        int[] numbers1 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] numbers2 = {1, 3 , 2};

        SortingAlgorithms sortingAlgorithms = new SortingAlgorithms();
        System.out.println(Arrays.toString(sortingAlgorithms.bubbleSort(numbers)));
        System.out.println(Arrays.toString(sortingAlgorithms.bubbleSort(numbers1)));
        System.out.println(Arrays.toString(sortingAlgorithms.bubbleSort(numbers2)));
    }
}