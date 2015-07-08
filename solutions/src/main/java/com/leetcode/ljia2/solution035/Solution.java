package com.leetcode.ljia2.solution035;

/**
 * Given a sorted array and a target value, return the index if the target is found. 
 * If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array. 
 * Here are few examples. 
 * [1,3,5,6], 5 ¡ú 2
 * [1,3,5,6], 2 ¡ú 1
 * [1,3,5,6], 7 ¡ú 4
 * [1,3,5,6], 0 ¡ú 0
 * 
 * 
 * Solution: find the first element that are bigger or equal to the target. 
 * 
 * corner case I: target is bigger than the last biggest element, then insert the new last index
 * corner case II: target is smaller/or equal to the first smaller element, then insert at index 0
 * 
 * Note recursive method, we might get indexes of all elements bigger than target, return the min one. 
 **/

public class Solution {
	public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0)  return -1;
        if(nums[0] >= target){ 
        	return 0; 
        }else if(nums[nums.length-1] < target){ 
        	return nums.length; 
        }else{
        	return binarySearchInsert(nums, 0, nums.length-1, target);
        }
    }
	
	public int binarySearchInsert(int[] nums, int start, int end, int target){
		if(start == end){
			if(nums[start] < target){
				return -1;
			}else{
				return start;
			}
		}else{
			// [3, 4, 7, 9, 10] and target = 8
			if(nums[end] < target){
				return -1;
			}else{
				int mid = (int) (start + end)/2;
				int index1 = binarySearchInsert(nums, start, mid, target);
				int index2 = binarySearchInsert(nums, mid+1, end, target);
				if(index1 > 0 && index2 > 0){
					return Math.min(index1, index2);
				}else{
					return Math.max(index1, index2);
				}
			}
		}
	}
}
