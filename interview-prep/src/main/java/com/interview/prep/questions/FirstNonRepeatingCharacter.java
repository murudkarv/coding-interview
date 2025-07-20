package com.interview.prep.questions;
//Given a string, find the first non-repeating character in it and return its index. If it doesn’t exist, return -1.
//
//Example questions:
//
//Consider a string where all characters are lowercase alphabets.
//Example 1:
//
//Input:
//
//s = 'helloworld'
//Output:
//
//first_uniq_char(s) -> 0
//In the string ‘helloworld’, the first non-repeating character is ‘h’, which is at index 0.
//
//Example 2:
//
//Input:s = 'concussion'
//Output:
//
//first_uniq_char(s) -> 4
//In the string ‘concussion’, the first non-repeating character is ‘u’, which is at index 4.

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {

    static int firstUniqueCharacter(String input){

        Map<Character, Integer> countMap = new HashMap<>();
        for(char c : input.toCharArray()){
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        for(int i = 0; i < input.length(); i++){
            if(countMap.get(input.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }

    // Example usage
    public static void main(String[] args) {
        System.out.println(firstUniqueCharacter("helloworld")); // Output: 0
        System.out.println(firstUniqueCharacter("concussion")); // Output: 4
        System.out.println(firstUniqueCharacter("aabbcc"));      // Output: -1
    }
}
