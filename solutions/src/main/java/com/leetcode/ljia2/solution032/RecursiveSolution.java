package com.leetcode.ljia2.solution032;

public class RecursiveSolution {
	public int longestValidParentheses(String s) {
        if(isValid(s))
        	return s.length();
        return Math.max(longestValidParentheses(s.substring(1)), longestValidParentheses(s.substring(0, s.length()-1)));
    }
	
	public boolean isValid(String s){		
		if(s.equals("()"))
			return true;
		else if(s.equals(")") || s.equals("("))
			return false;
		
		char[] carray = s.toCharArray();
		int match = 0;
		for(char c : carray){
			if(c == '(')
				match += 1;
			else if(c == ')')
				match -= 1;
			if(match < 0){
				return false;
			}			
		}
		return match == 0? true : false;
	}
}
