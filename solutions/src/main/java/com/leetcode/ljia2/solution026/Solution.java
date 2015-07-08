package com.leetcode.ljia2.solution026;

import java.util.Arrays;

/**
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * For example,
 * Given input array nums = [1,1,2], Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
 ***/

public class Solution {
	public int removeDuplicates(int[] nums) {
		if(nums == null || nums.length == 0){
			return 0;
		}
		Arrays.sort(nums);
		int newlength = 1;
		int lastnum = nums[0];
		for(int index = 1; index < nums.length; index++){
			if(nums[index] != lastnum){
				lastnum = nums[index];
				nums[newlength] = nums[index];
				newlength++;
			}
		}
		return newlength;
    }
}
