package com.leetcode.ljia2.solution136;

import java.util.Arrays;

/**
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 **/

public class SolutionII {
	public int singleNumber(int[] nums){
		if(nums.length == 1){
			return nums[0];
		}else{
			Arrays.sort(nums);
			int start = 0;
			while(start + 1 < nums.length && nums[start] == nums[start+1]){
				start += 2;
			}
			return nums[start];
		}
	}
}
