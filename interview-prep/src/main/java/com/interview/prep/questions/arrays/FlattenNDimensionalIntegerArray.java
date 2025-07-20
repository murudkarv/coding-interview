package com.interview.prep.questions.arrays;

//You are given an N-dimensional array (a nested list) and your task is to convert it into a 1D array.
// The N-dimensional array can have any number of nested lists and each nested list can contain any number of elements.
// The elements in the nested lists are integers. Write a function that takes an N-dimensional array as input and returns a 1D array.

//Example 1:
//Input - array = [1, [2, 3], [4, [5, 6]], 7]
//Output - flatten_array(array) -> [1, 2, 3, 4, 5, 6, 7]
//Example 2:
//Input - array - [[1, 2], [3, 4], [5, 6]]
//Output - flatten_array(array) -> [1, 2, 3, 4, 5, 6]

import java.util.ArrayList;
import java.util.List;

public class FlattenNDimensionalIntegerArray {
    static List<Integer> flattenArray(List<?> input, List<Integer> flattenArray){
        input.forEach(obj ->
        {
            if(obj instanceof List<?>){
                flattenArray((List<?>) obj, flattenArray);
            }else {
                flattenArray.add((Integer) obj);
            }
        });
        return flattenArray;
    }

    // Example usage
    public static void main(String[] args) {
        List<Object> input1 = List.of(1, List.of(2, 3), List.of(4, List.of(5, 6)), 7);
        System.out.println(flattenArray(input1, new ArrayList<>())); // Output: [1, 2, 3, 4, 5, 6, 7]
        List<Object> input2 = List.of(List.of(1, 2), List.of(3, 4), List.of(5, 6));
        System.out.println(flattenArray(input2, new ArrayList<>())); // Output: [1, 2, 3, 4, 5, 6]
    }
}
