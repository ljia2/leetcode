package com.leetcode.ljia2.solution017;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<String> letterCombinations(String digits) {
		String[] stringSets = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		List<String> results = new ArrayList<String>();
		if(digits == null || digits.equals("")){
			return results;
		}else if(digits.length() == 1){
			char d = digits.charAt(0);
			int index = d - '0';
			String stringSet = stringSets[index];
			for(int cindex = 0; cindex < stringSet.length(); cindex++){
				results.add(stringSet.substring(cindex, cindex+1));
			}
			return results;
		}else{
			char d = digits.charAt(0);
			int index = d - '0';
			List<String> preresults = letterCombinations(digits.substring(1));
			String stringSet = stringSets[index];
			for(int cindex = 0; cindex < stringSet.length(); cindex++){
				for(String result : preresults){
					results.add(stringSet.substring(cindex, cindex+1) + result);
				}
			}
			return results;
		}
	}
}
