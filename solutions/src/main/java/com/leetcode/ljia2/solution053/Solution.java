package com.leetcode.ljia2.solution053;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 * the contiguous subarray [4,−1,2,1] has the largest sum = 6. 
 * 
 * O(n) solution: 
 *    given a maximum subarray, the prefix subarray must have a sum of <= 0 and the affix subarray also must have a sum of <=0
 *    therefore, we can just calculate sum from the start and reset sum when sum < 0; 
 * **/
public class Solution {
	public int maxSubArray(int[] nums) {
		if(nums == null || nums.length == 0) return 0;
		int maxSum = Integer.MIN_VALUE;
		int sum = 0;
		for(int i = 0; i < nums.length; i++){
			sum += nums[i];
			maxSum = Math.max(sum, maxSum);
			if(sum < 0){ sum = 0; }
		}
		return maxSum;
    }
}
