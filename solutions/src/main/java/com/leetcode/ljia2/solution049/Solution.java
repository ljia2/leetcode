package com.leetcode.ljia2.solution049;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of strings, return all groups of strings that are anagrams.
 * Note: All inputs will be in lower-case.
 * **/

public class Solution {
	public List<String> anagrams(String[] strs) {
		List<String> results = new ArrayList<String>();
		if(strs == null || strs.length == 0) return results;
		
        Map<String, List<String>> anahash = new HashMap<String, List<String>>();
        for(String str : strs){
        	String key = toAnagram(str);
        	if(anahash.containsKey(key)){
        		List<String> list = anahash.get(key);
        		list.add(str);
        		anahash.put(key, list);
        	}else{
        		List<String> list = new ArrayList<String>();
        		list.add(str);
        		anahash.put(key, list);
        	}
        }
        
        for(String key : anahash.keySet()){
        	if(anahash.get(key).size()> 1){
        		results.addAll(anahash.get(key));
        	}
        }
        return results;
    }
	
	public String toAnagram(String str){
		if(str == null || str.length() == 0) return str;
		char[] carray = str.toCharArray();
		Arrays.sort(carray);
		return new String(carray);
	}
}
