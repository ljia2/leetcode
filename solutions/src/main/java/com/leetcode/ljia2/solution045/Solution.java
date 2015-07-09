package com.leetcode.ljia2.solution045;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 * For example:
 * Given array A = [2,3,1,1,4]
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 * 
 * Solution: 
 *    1) start from the last to find out the left most index, last_index, what is one step away from the last element.
 *    2) start from last_index to find out the left most index, last_index', which is one step away from the last_index
 *    3) if not reach the first index, last_index = last_index' and repeat steps 2) and 3). 
 *    
 * Idea: always find the left most index that is one step away from the last left most index in a greey way. The greedy manner can guarantee the minimum results. 
 * 
 * 
 * **/
public class Solution {
	public int jump(int[] nums) {
        if(nums == null || nums.length == 0 || nums.length == 1) return 0;
        int lastIndex = nums.length - 1;
        int step = 0;
        while(lastIndex > -1){
        	int leftIndex = 0;
        	for(int index = 0; index < lastIndex; index++){
        		if(index + nums[index] >= lastIndex){
        			// start for the left to find the left most one reaching the element at lastIndex. 
        			leftIndex = index;
        			break;
        		}
        	}
        	if(leftIndex < lastIndex){
        		step += 1;
        		if(leftIndex == 0) return step;
        		lastIndex = leftIndex;
        	}else{
        		return -1;
        	}
        }
        return step;
    }
}
