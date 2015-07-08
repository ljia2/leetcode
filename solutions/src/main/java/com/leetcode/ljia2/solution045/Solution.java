package com.leetcode.ljia2.solution045;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 * For example:
 * Given array A = [2,3,1,1,4]
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 * 
 * numstep2last[i] = j mean the minimum num of steps from i to last is j. 
 * from the last element to the first element to calculate numstep2last array. 
 * 
 * **/
public class Solution {
	public int jump(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int[] numstep2last = new int[nums.length];
        int indexOfMinimumStep2Last = Integer.MAX_VALUE;
        for(int index = nums.length - 1; index > -1; index--){
        	if(index == nums.length - 1){
        		numstep2last[index] = 0;
        		indexOfMinimumStep2Last = index;
        	}else{
        		// early stop condition
        		if(nums[0] >= indexOfMinimumStep2Last){
        			return numstep2last[indexOfMinimumStep2Last] + 1;
        		}else{
        			// direct reach last element
        			if(index + nums[index] >= nums.length - 1){
        				numstep2last[index] = 1;
        			}else{
        				if(index + nums[index] >= indexOfMinimumStep2Last){
        					numstep2last[index] = numstep2last[indexOfMinimumStep2Last] + 1;
        				}else{
				    		int min_num_step2last = Integer.MAX_VALUE;
				    		for(int step = index + 1; step < Math.min(nums.length, index + nums[index] + 1); step++){
				    			if (min_num_step2last > numstep2last[step] + 1){
				    				min_num_step2last = numstep2last[step] + 1;
				    			}
				    		}
				    		numstep2last[index] = min_num_step2last;
        				}
        			}		    		
        		}
        	}
        }
        return numstep2last[0];
    }
}
