package com.leetcode.ljia2.solution058;
/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 * If the last word does not exist, return 0.
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * For example, 
 * Given s = "Hello World",
 * return 5.
 * 
 * */
public class Solution {
	public int lengthOfLastWord(String s) {
		if(s == null || s.trim().length() == 0) return 0;
		s = s.trim();
        int lastIndexSpace = s.lastIndexOf(" ");
        if(lastIndexSpace > -1){
        	return s.length() - 1 - lastIndexSpace;
        }else{
        	return s.length();
        }       
    }
}
