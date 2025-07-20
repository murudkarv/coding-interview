package com.interview.prep.sorting;

public class SortingAlgorithms {
    /*
        Bubble up the sorted numbers at the end of the array by iterating through the list
     */
    public int[] bubbleSort(int[] numbers){
        int tmp;
        for(int i = 0; i < numbers.length; i++){                 // iterate through whole array one by one
            for(int j = 0; j < numbers.length - i - 1; j++){      // iterate through 0th element to [length - (sorted numbers at the end of array) - 1]
                if(numbers[j] > numbers[j + 1]){
                    tmp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = tmp;
                }
            }
        }
        return numbers;
    }

    /*
        Insert the number in empty array one by one smallest to largest
     */
    public int[] insertionSort(int[] numbers){
        int current;
        for(int i = 1; i < numbers.length; i++){ // iterate through whole array one by one
            current = numbers[i];
            int j = i - 1;
            while(j > -1 && current < numbers[j]){
                numbers[j + 1] = numbers[j];
                j--;
            }
            numbers[j + 1] = current;
        }
        return numbers;
    }
}
