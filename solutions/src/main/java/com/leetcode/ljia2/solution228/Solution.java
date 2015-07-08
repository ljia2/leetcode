package com.leetcode.ljia2.solution228;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array without duplicates, return the summary of its ranges. 
 * For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 * ***/
public class Solution {
	public List<String> summaryRanges(int[] nums) {
        List<String> results = new ArrayList<String>();
        if(nums == null || nums.length == 0) return results;
        int start = 0;
        int end = start;
        while(start < nums.length){
        	while(end < nums.length && nums[end] - nums[start] == end - start){
        		end += 1;
        	}
        	if(end > start + 1){
        		results.add(nums[start] + "->" + nums[end-1]);
        		start = end;
        	}else{
        		results.add(String.valueOf(nums[start]));
        		start = end;
        	}
        }
        return results;
    }
}
