package com.interview.prep.questions.arrays;

import java.util.List;

//Leetcode_74
//You are given an m x n integer matrix matrix with the following two properties:
//
//Each row is sorted in non-decreasing order.
//The first integer of each row is greater than the last integer of the previous row.
//Given an integer target, return true if target is in matrix or false otherwise.
//
//You must write a solution in O(log(m * n)) time complexity.
//
//
//
//Example 1:
//
//
//Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//Output: true
//Example 2:
//
//
//Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//Output: false
//
//
//Constraints:
//
//m == matrix.length
//n == matrix[i].length
//1 <= m, n <= 100
//        -104 <= matrix[i][j], target <= 104
public class TwoDimensionalArraySearch {

    public static boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix[0].length;
        int m = matrix.length;

        return binarySearchRecursion(matrix, target, n, 0, m*n-1);
    }


    // Imagining 2D array as one single sorted 1D array  // Tc- Olog n*m, Sc - Olog(m*n)
    public static boolean binarySearchRecursion(int[][] array, int target, int rowSize, int lowerBound, int upperBound){

        if(lowerBound > upperBound){
            return false;
        }
        int mid = lowerBound + (upperBound - lowerBound)/2;
        // 1D array index from 2D array indexes = i*n+j, where n is no of elements in row/no of columns in matrix
        // to get 2D indexes from 1D index -> i =  index/n, j = index%n
        if(array[mid/rowSize][mid%rowSize] == target)
            return true;
        else if (array[mid/rowSize][mid%rowSize] < target)
            return binarySearchRecursion(array, target, rowSize, mid + 1, upperBound);
        else
            return binarySearchRecursion(array, target, rowSize, lowerBound, mid - 1);
    }

    // Imagining 2D array as one single sorted 1D array  // Tc- Olog n*m, Sc - O(1)
    public static boolean binarySearchIterative(int[][] array, int target, int rowSize, int lowerBound, int upperBound){
        while(lowerBound <= upperBound) {
            int mid = lowerBound + (upperBound - lowerBound) / 2;
            // 1D array index from 2D array indexes = i*n+j, where n is no of elements in row/no of columns in matrix
            // to get 2D indexes from 1D index -> i =  index/n, j = index%n
            if (array[mid / rowSize][mid % rowSize] == target)
                return true;
            else if (array[mid / rowSize][mid % rowSize] < target)
                lowerBound = mid + 1;
            else
                upperBound = mid - 1;
        }
        return false;
    }

    public static void main(String[] args) {

        int[][] matrix = new int[][]{{1,3,5,7}, {10,11,16,20}, {23,30,34,60}};
        System.out.println(searchMatrix(matrix, 3)); // Output: true
        System.out.println(searchMatrix(matrix, 13)); // Output: false
    }
}
