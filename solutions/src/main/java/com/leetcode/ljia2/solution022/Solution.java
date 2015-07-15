package com.leetcode.ljia2.solution022;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 *
 *Solution:
 *Base case: return value is "()" if n == 1. 
 *Recursion: answer is the combination of "()" and generatePaenthesis(n - 1). 
 *In order to get that, for each string in the list, insert "()" in every position until the end.
 *
 */

public class Solution {
	public List<String> generateParenthesis(int n) {
		List<String> results = new ArrayList<String>();
        if(n <= 0){
        	return results;
        }else if(n == 1){
        	results.add("()");
        	return results;
        }else{
        	Set<String> tracker = new HashSet<String>();
        	List<String> preresults = generateParenthesis(n-1);
        	for(String result : preresults){
        		for(int index = 0; index < result.length(); index++){
        			String newresult = result.substring(0, index) + "()" + result.substring(index);
        			tracker.add(newresult);
        		}
        		tracker.add(result + "()");
        		tracker.add("()" + result);
        	}
        	results.addAll(tracker);
        	return results;
        }
    }	
}
