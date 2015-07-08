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
 *    boolean[] reachLast = new boolean[nums.length];
 *    from the last element to the first.
 *    
 *    reachLast[i] = true, index i can reach last
 *    reachLast[i] = false, index i cannot reach last
 *    
 *    lastTrueIndex: the samllest index whose value is True. 
 *    
 *    for a index i, if i + nums[i] >= lastTrueIndex, then reachLast[i] = true; otherwise reachLast[i] = false;
 * **/
public class Solution {
	public boolean canJump(int[] nums) {
		if(nums == null || nums.length == 0) return false;
		boolean[] reachLast = new boolean[nums.length];
		int smallestTrueIndex = nums.length;
		for(int index = nums.length - 1; index > -1; index--){
			if(index == nums.length - 1){
				smallestTrueIndex = index;
				reachLast[index] = true;
 			}else{
 				if(index + nums[index] >= smallestTrueIndex){
 					reachLast[index] = true;
 					smallestTrueIndex = index;
 				}else{
 					reachLast[index] = false;
 				}
 			}
		}
		return reachLast[0];
	}
}
