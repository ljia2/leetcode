package com.leetcode.ljia2.solution014;

/** Write a function to find the longest common prefix string amongst an array of strings. **/

public class Solution {
	public String longestCommonPrefix(String[] strs){
		if(strs.length == 0){
			return "";
		}else if(strs.length == 1){
			return strs[0];
		}else{
			String lcprefix = strs[0];
			for(int index = 1; index < strs.length; index++){
				char[] list1 = lcprefix.toCharArray();
				char[] list2 = strs[index].toCharArray();
				lcprefix = "";
				for(int i = 0; i < Math.min(list1.length, list2.length); i++){
					if(list1[i] == list2[i]){
						lcprefix += list1[i];
					}else{
						break;
					}
				}
				if(lcprefix.equalsIgnoreCase("")){
					return lcprefix;
				}
			}
			return lcprefix;
		}
	}
}
