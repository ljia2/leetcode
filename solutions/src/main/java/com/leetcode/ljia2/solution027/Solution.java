package com.leetcode.ljia2.solution027;

import java.util.Arrays;

/***
 * Given an array and a value, remove all instances of that value in place and return the new length. 
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * */
public class Solution {
	public int removeElement(int[] nums, int val) {
		if(nums == null || nums.length == 0){
			return 0;
		}
        Arrays.sort(nums);
        int index = 0;
        while(index < nums.length){
        	if(nums[index] == val){
        		int runner = index;
        		while(runner < nums.length){
        			if(nums[runner] != val){
        				break;
        			}else{
        				runner += 1;
        			}
        		}
        		if(runner < nums.length){
        			while(runner < nums.length){
        				nums[index] = nums[runner];
        				index += 1;
        				runner += 1;
        			}        			
        		}
        		break;
        	}else{
        		index += 1;
        	}
        }
        return index;
    }	
}
