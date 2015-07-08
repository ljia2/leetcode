package com.leetcode.ljia2.solution217;

import java.util.HashSet;
/**
 * Given an array of integers, find if the array contains any duplicates. 
 * Your function should return true if any value appears at least twice in the array, 
 * and it should return false if every element is distinct.
 **/
public class Solution {
	public boolean containsDuplicate(int[] nums) {
		if(nums == null || nums.length == 0)
			return false;
		
        HashSet<Integer> counthash = new HashSet<Integer>();
        for(int num : nums){
        	if(counthash.contains(num)){
        		return true;
        	}else{
        		counthash.add(num);
        	}
        }
        return false;
    }
}
