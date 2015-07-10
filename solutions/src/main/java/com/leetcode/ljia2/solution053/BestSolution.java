package com.leetcode.ljia2.solution053;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 * the contiguous subarray [4,−1,2,1] has the largest sum = 6. 
 * 
 * More practice:
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 * **/

public class BestSolution {
	public int maxSubArray(int[] nums) {
		if(nums == null || nums.length == 0) return 0;
		int start = 0;
		int end = nums.length - 1;
		int mid = (start + end)/2;
		int maxLeft = binaryMaxSubArray(nums, start, mid);
		int maxRight = binaryMaxSubArray(nums, mid + 1, end);
		
		int max = Math.max(maxLeft, maxRight);
	}
}
