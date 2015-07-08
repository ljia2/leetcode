package com.leetcode.ljia2.solution018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? 
 * Find all unique quadruplets in the array which gives the sum of target.
 * Note: 
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ¡Ü b ¡Ü c ¡Ü d)
 * The solution set must not contain duplicate quadruplets.
 * For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 * A solution set is:
 * (-1,  0, 0, 1)
 * (-2, -1, 1, 2)
 * (-2,  0, 0, 2)
 * **/

public class Solution {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		HashSet<List<Integer>> tracker = new HashSet<List<Integer>>();
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		if(nums == null || nums.length < 4){
			return results;
		}
		Arrays.sort(nums);
		for(int a = 0; a < nums.length; a++){
			for(int b = a + 1; b < nums.length; b++){
				int c = b + 1;
				int d = nums.length - 1;
				while(c < d){
					int sum = nums[a] + nums[b] + nums[c] + nums[d];
					if(sum == target){
						List<Integer> result = new ArrayList<Integer>();
						result.add(nums[a]);
						result.add(nums[b]);
						result.add(nums[c]);
						result.add(nums[d]);
						if(tracker.add(result)){
							results.add(result);
						}						
						c += 1;
						while(c < d && nums[c] == nums[c-1]){
							c += 1;
						}
						d -= 1;
						while(c < d && nums[d] == nums[d+1]){
							d -= 1;
						}
					}else if(sum < target){
						c += 1;
						while(c < d && nums[c] == nums[c-1]){
							c += 1;
						}
					}else if(sum > target){
						d -= 1;
						while(c < d && nums[d] == nums[d+1]){
							d -= 1;
						}
					}
				}
			}
		}
		return results;
    }
}
