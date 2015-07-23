package com.leetcode.ljia2.solution189;

public class BestSolution {
	public void rotate(int[] nums, int k) {
		k = k % nums.length;
		if(k == 0) return;
		swap(nums, 0, nums.length-1);
		swap(nums, 0, k-1);
		swap(nums, k, nums.length-1);
	}
	public void swap(int[] nums, int start, int end){
		while(start < end){
			int tmp = nums[start];
			nums[start] = nums[end];
			nums[end] = tmp;
			start += 1;
			end -= 1; 
		}
	}
}
