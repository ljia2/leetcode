package com.leetcode.ljia2.solution033;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand. (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 * **/

public class Solution {
	public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0)
        	return -1;
        return binarySearch(nums, 0, nums.length-1, target);
    }
	public int binarySearch(int[] nums, int start, int end, int target){
		if(start == end){
			if(nums[start] == target){
				return start;
			}else{
				return -1;
			}
		}else{
			if(nums[start] < nums[end]){
				if(nums[start] <= target && nums[end]>=target){
					int mid = (int)(start+end)/2;
					return Math.max(binarySearch(nums, start, mid, target), binarySearch(nums, mid+1, end, target));
				}else{
					return -1;
				}
			}else{
				if(nums[start] <= target || nums[end] >= target){
					int mid = (int) (start + end)/2;
					return Math.max(binarySearch(nums, start, mid, target), binarySearch(nums, mid+1, end, target));
				}else{
					return -1;
				}
			}
		}
	}
}
