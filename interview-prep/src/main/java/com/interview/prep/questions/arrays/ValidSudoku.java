package com.interview.prep.questions.arrays;

import java.util.*;
import java.util.stream.Collectors;

//LeetCode_36
//Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
//
//Each row must contain the digits 1-9 without repetition.
//Each column must contain the digits 1-9 without repetition.
//Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
//Note:
//
//A Sudoku board (partially filled) could be valid but is not necessarily solvable.
//Only the filled cells need to be validated according to the mentioned rules.
//
//
//        Example 1:
//
//
//Input: board =
//        [["5","3",".",".","7",".",".",".","."]
//        ,["6",".",".","1","9","5",".",".","."]
//        ,[".","9","8",".",".",".",".","6","."]
//        ,["8",".",".",".","6",".",".",".","3"]
//        ,["4",".",".","8",".","3",".",".","1"]
//        ,["7",".",".",".","2",".",".",".","6"]
//        ,[".","6",".",".",".",".","2","8","."]
//        ,[".",".",".","4","1","9",".",".","5"]
//        ,[".",".",".",".","8",".",".","7","9"]]
//Output: true
//Example 2:
//
//Input: board =
//        [["8","3",".",".","7",".",".",".","."]
//        ,["6",".",".","1","9","5",".",".","."]
//        ,[".","9","8",".",".",".",".","6","."]
//        ,["8",".",".",".","6",".",".",".","3"]
//        ,["4",".",".","8",".","3",".",".","1"]
//        ,["7",".",".",".","2",".",".",".","6"]
//        ,[".","6",".",".",".",".","2","8","."]
//        ,[".",".",".","4","1","9",".",".","5"]
//        ,[".",".",".",".","8",".",".","7","9"]]
//Output: false
//Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
//
//
//Constraints:
//
//board.length == 9
//board[i].length == 9
//board[i][j] is a digit 1-9 or '.'.
public class ValidSudoku {
    public static boolean isValidSudoku(char[][] board) {
        // Rowno - Values, 0 - 8, 1-9
        Map<Integer, Integer> rowMap = new HashMap<>();
        // Column no - values
        Map<Integer, Integer> columnMap = new HashMap<>();
        // Box no Value
        // box 1 -> row <=2 , cloumn <=2,
        // box 2 -> row <=2, < columns < 6,
        // box3 -> row <=2, colum >= 6
        Map<Integer, List<Integer>> boxMap = new HashMap<>();

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                int value = Character.getNumericValue(board[i][j]);
                int value1 = Character.getNumericValue(board[j][i]);
                if(value != -1) {
                    if (rowMap.containsKey(value) && rowMap.get(value) == i)
                        return false;
                    else
                        rowMap.put(value, i);

                    if (!boxMap.containsKey(getBoxNo(i, j)))
                        boxMap.put(getBoxNo(i, j), new ArrayList<>());
                    boxMap.get(getBoxNo(i, j)).add(value);

                }
                if(value1 != -1){
                    if(columnMap.containsKey(value1) && columnMap.get(value1) == i)
                        return false;
                    else
                        columnMap.put(value1, i);
                }
            }
        }
        for(Map.Entry entry : boxMap.entrySet()){
            List<Integer> list = (List) entry.getValue();
            if(list.size() != list.stream().distinct().collect(Collectors.toList()).size())
                return false;
        }
        return true;
    }

    static int getBoxNo(int row, int column){
        return (row / 3) * 3 + (column / 3) + 1;
    }

    public static void main(String[] args){
        System.out.println(isValidSudoku(new char[][]{
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}}));
    }
}
