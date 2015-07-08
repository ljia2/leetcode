package com.leetcode.ljia2.solution034;

/***
 * Given a sorted array of integers, find the starting and ending position of a given target value. 
 * Your algorithm's runtime complexity must be in the order of O(log n). 
 * If the target is not found in the array, return [-1, -1].
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8, return [3, 4].
 * 
 * */

public class Solution {
	public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0)
        	return new int[]{-1, -1};
        return binarySearchRange(nums, 0, nums.length-1, target);
    }
	
	public int[] binarySearchRange(int[] nums, int start, int end, int target){
		if(start == end){
			if(nums[start] == target){
				return new int[]{start, start};
			}else{
				return new int[]{-1, -1};
			}
		}else{
			if(nums[start] <= target && nums[end] >= target){
				int mid = (int) (start + end)/2;
				return merge(binarySearchRange(nums, start, mid, target), binarySearchRange(nums, mid+1, end, target));
			}else{
				return new int[]{-1, -1};
			}
		}
	}
	
	public int[] merge(int[] range1, int[] range2){
		if(range1[1] == -1 && range2[0] == -1){
			return range1;
		}else if(range1[1] == -1){
			return range2;
		}else if(range2[0] == -1){
			return range1;
		}else{
			return new int[]{range1[0], range2[1]};
		}
	}
}
