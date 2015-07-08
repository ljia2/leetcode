package com.leetcode.ljia2.solution020;

/***
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * */

public class Solution {
	public boolean isValid(String s) {
        if(s == null || s.equalsIgnoreCase("")){
        	return true;
        }
        char[] clist = s.trim().toCharArray();
        char[] stack = new char[clist.length];
        int stack_ptr = -1;
        
        for(char c : clist){
        	if(c == '(' || c == '{' || c == '['){
        		stack_ptr += 1;
        		stack[stack_ptr] = c;
        	}else if(c == ')' || c == '}' || c == ']'){
        		if(stack_ptr > -1){
        			if(c == ')' && stack[stack_ptr] == '('){
        				stack_ptr -= 1;
        			}else if(c == '}' && stack[stack_ptr] == '{'){
        				stack_ptr -= 1;
        			}else if(c == ']' && stack[stack_ptr] == '['){
        				stack_ptr -= 1;
        			}else{
        				return false;
        			}        				
        		}else{
        			return false;
        		}
        	}
        }
        return stack_ptr == -1? true : false;
    }
}
