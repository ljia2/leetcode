package com.leetcode.ljia2.solution009;

public class Solution {
	public boolean isPalindrome(int x) {
        if(x < 0) return false;
        if(x < 10) return true;
        String num = String.valueOf(x);
        int start = 0;
        int end = num.length()-1;
        while(start < end){
        	if(num.charAt(start) != num.charAt(end)){
        		return false;
        	}
        	start += 1;
        	end -= 1;
        }
        return true;
    }
}
