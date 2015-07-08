package com.leetcode.ljia2.solution055;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * For example: 
 * A = [2,3,1,1,4], return true.
 * A = [3,2,1,0,4], return false.
 * 
 * Solution:
 *    1) start from the first element E: 
 *    1.1) for each element E' reachable from E: recursively as whether we can reach last from E' 
 *    
 *    Recursive Function canJump2Last(int[] nums, int start): 
 *    	if nums[start] + start >= nums.length-1: return true
 *    	if nums[start] == 0 return false;
 *    
 *    	for each reach position(index) i of nums[start], recursively call camJump2Last by start = i. 
 * 
 * **/
public class RecusiveSolution {
	public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0) return false;
        boolean result = false;
        for(int i = 1; i <= Math.min(nums.length-1, nums[0]); i++){
        	result = result || canJump2Last(nums, i);
        	if(result) return result;
        }
        return result;
    }
	
	public boolean canJump2Last(int[] nums, int start){
		if(start + nums[start] >= nums.length - 1) return true;
		if(nums[start] == 0) return false;
		boolean result = false;
		for(int i = start + 1; i <= Math.min(nums.length-1, start + nums[start]); i++){
			result = result || canJump2Last(nums, i);
			if (result) return result;
		}
		return result;
	}
}
