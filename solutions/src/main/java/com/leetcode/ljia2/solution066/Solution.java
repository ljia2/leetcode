package com.leetcode.ljia2.solution066;
/**
 * Given a non-negative number represented as an array of digits, plus one to the number.
 * The digits are stored such that the most significant digit is at the head of the list.
 * 
 * **/
public class Solution {
	public int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0) return null;
        boolean allNines = true;
        for(int digit : digits){
        	if(digit != 9){
        		allNines = false;
        		break;
        	}
        }
        
        int[] results;
        if(allNines){
        	results = new int[digits.length+1];
        }else{
        	results = new int[digits.length];
        }
        
        int rindex = results.length-1;
        // add-one: initialize the carryon to 1
        int carryon = 1;
        for(int index = digits.length-1; index >= 0; index--){
        	if(digits[index] + carryon == 10){
        		carryon = 1;
        		results[rindex] = 0;
        	}else{
        		results[rindex] = digits[index] + carryon;
        		carryon = 0;        		
        	}
        	rindex--;
        }
        // take care the new highest digit 
        if(rindex == 0){
        	results[rindex] = carryon;
        }
        
        return results;
    }
}
