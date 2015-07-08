package com.leetcode.ljia2.solution032;

import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 * For "(()", the longest valid parentheses substring is "()", which has length = 2. 
 * Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 * 
 * Solution: use an array length where length[i] = j mean the substring starting at i with a length of j is a valid parthesis string
 * 
 * scan from the rear end, 
 *    if encounter ')' at index k, we set length[k] = 0
 *    if encounter '(' at index k, 
 *    	we check whether char at the index of k' = [k + length[k+1] + 1] is ')'
 *              if matched, we found a match. length[k] = length[k+1] + 2 + length[k'+1] 
 *              if not matched, length[k] = 0
 *          
 *        
 * 
 * **/

public class Solution{
	public int longestValidParentheses(String s) {
		if(s == null || s.length() == 0 || s.length() == 1) return 0;
		// substr_length[i] = j means the substring starting at i with a length of j is a valid parenthesis string
		int[] substr_length = new int[s.length()];
		for(int index = substr_length.length - 1; index > -1; index--){
			if(s.charAt(index) == ')'){
				substr_length[index] = 0;
			}else{
				// s.charAt(index) == '('
				if(index + 1 < s.length()){
					int checkpoint = index + substr_length[index+1] + 1;
					if(checkpoint < s.length() && s.charAt(checkpoint) == ')'){
						if(checkpoint < s.length()-1){
							substr_length[index] = substr_length[index+1] + 2 + substr_length[checkpoint+1];
						}else{
							substr_length[index] = substr_length[index+1] + 2;
						}
					}else{
						substr_length[index] = 0;
					}
				}else{
					substr_length[index] = 0;
				}
			}
		}
		
		int max_length = 0;
		for(int length : substr_length){
			if(max_length < length) max_length = length;
		}
		return max_length;
	}
}
