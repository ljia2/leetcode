package com.leetcode.ljia2.solution038;

public class Solution {
	public String countAndSay(int n) {
        String initialString = "1";
        if(n == 1) return initialString;
        return sayString(initialString, n-1);
    }
	public String sayString(String s, int n){
		if(n == 0) return s;
		else{
			StringBuilder say = new StringBuilder();
			char[] clist = s.toCharArray();
			int start = 0;
			int end = 0;
			int count = 0;
			int digit = clist[0] - '0';
			while(start < clist.length){
				while(end < clist.length && clist[end] == clist[start]){
					end += 1;
					count += 1;
				}
				say.append(count);
				say.append(digit);
				if(end < clist.length){
					start = end;
					end = start;
					digit = clist[start] - '0';
					count = 0;
				}else{
					break;
				}
			}
			return sayString(say.toString(), n-1);
		}
	}
}
