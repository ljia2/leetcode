package com.leetcode.ljia2.solution053;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 * the contiguous subarray [4,−1,2,1] has the largest sum = 6. 
 * 
 * **/
public class Solution {
	public int maxSubArray(int[] nums) {
		if(nums == null || nums.length == 0) return 0;
		if(nums.length == 1) return nums[0];
		
		int sum = 0;
		for(int num : nums) sum += num;
		
		int start = 0, end = nums.length-1;
		int minleftrightsum = Integer.MAX_VALUE;
		int leftrightsum = 0;
		while(start <= end){
			minleftrightsum = Math.min(leftrightsum + nums[start] + nums[end], Math.min(leftrightsum + nums[start], leftrightsum + nums[end]));
			start += 1;
			end -= 1;
		}
		return sum - minleftrightsum;			
    }
}
