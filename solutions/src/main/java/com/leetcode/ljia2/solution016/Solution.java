package com.leetcode.ljia2.solution016;

import java.util.Arrays;

/**
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * **/

public class Solution {
	public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length < 3){
        	throw new RuntimeException("Input Error ");
        }
        
        Arrays.sort(nums);
        int targetgap = Integer.MAX_VALUE;
        for(int target_ptr = 0; target_ptr < nums.length ; target_ptr++){        	
        	int start_ptr = target_ptr + 1;
        	int end_ptr = nums.length - 1;
        	while(start_ptr < end_ptr){
        		int sum = nums[target_ptr] + nums[start_ptr] + nums[end_ptr];
        		if(target - sum == 0){
        			return target;
        		}else if(target > sum){
        			if(target - sum < Math.abs(targetgap)){
        				targetgap = sum - target;
        			}
        			start_ptr += 1;
        			while(start_ptr < end_ptr && nums[start_ptr] == nums[start_ptr-1]){
        				start_ptr += 1;
        			}
        		}else if(target < sum){
        			if(sum - target < Math.abs(targetgap)){
        				targetgap = sum - target;
        			}
        			end_ptr -= 1;
        			while(start_ptr < end_ptr && nums[end_ptr] == nums[end_ptr+1]){
        				end_ptr -= 1;
        			}
        		}
        	}
        }
        return target + targetgap;
    }
}
