package com.leetcode.ljia2.solution046;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of numbers, return all possible permutations. 
 * For example,
 * [1,2,3] have the following permutations:
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 * 
 * **/

public class Solution {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0) return results;
        generatePermutation(nums, 0, results);
        return results;
    }
	
	public void generatePermutation(int[] nums, int start, List<List<Integer>> results){
		if(start == nums.length - 1){
			List<Integer> result = new ArrayList<Integer>();
			result.add(nums[start]);
			results.add(result);
		}else{
			List<List<Integer>> tracker = new ArrayList<List<Integer>>();
			generatePermutation(nums, start + 1, results);
			for(List<Integer> result : results){
				
			}
		}
	}
}
