package com.leetcode.ljia2.solution169;

import java.util.HashMap;

/**
 * Given an array of size n, find the majority element. The majority element is the element that appears more than int(n/2) times.
 * You may assume that the array is non-empty and the majority element always exist in the array. 
 * 
 * Trick: there is at most one majority element
 */


public class Solution {
	public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> numscount = new HashMap<Integer, Integer>();
        int max_count = 0;
        int max_count_int = 0;
        for(int num : nums){
        	if(numscount.containsKey(num)){
        		if(max_count < numscount.get(num) + 1){
        			max_count = numscount.get(num) + 1;
        			max_count_int = num;
        		}
        		numscount.put(num, numscount.get(num) + 1);
        	}else{
        		if(max_count < 1){
        			max_count = 1;
        			max_count_int = num;
        		}
        		numscount.put(num, 1);
        	}
        }
        return max_count_int;
    }
}
