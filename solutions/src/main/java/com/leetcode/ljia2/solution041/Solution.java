package com.leetcode.ljia2.solution041;

import java.util.HashSet;

/**
 * Given an unsorted integer array, find the first missing positive integer. 
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2. 
 * Your algorithm should run in O(n) time and uses constant space.
 * 
 * Solution: scan each element E
 *    if E == 1 firstPositive = E + 1
 *    if E <= 0 firstPositive = 1 and check whether ther 1 is in the array, if not see whether firstPositive is smallest
 *    if E > 1: firstPositive = E-1 or E + 1and check  whetherfirstPositive in the array, if not see whether firstPositive is smallest
 * 
 * 
 * **/
public class Solution {
	public int firstMissingPositive(int[] nums) {
		if(nums == null || nums.length == 0) return 1;
        HashSet<Integer> numshash = new HashSet<Integer>();
        for(int num : nums){
        	if(num > 0) numshash.add(num);
        }
        int firstPositive = Integer.MAX_VALUE;
        for(int num : nums){
        	if(num <= 0){
        		int target = 1;
        		if(!numshash.contains(target)){
        			if(firstPositive > target){
        				firstPositive = target;
        			}
        		}
        	}else if(num == 1){
        		int target = num + 1;
        		if(!numshash.contains(target)){
        			firstPositive = Math.min(firstPositive, target);
        		}
        	}else if(num > 1){
        		int target = num - 1;
        		if(!numshash.contains(target)){
        			firstPositive = Math.min(firstPositive, target);
        		}else{
        			target = num + 1;
        			if(!numshash.contains(target)){
        				firstPositive = Math.min(firstPositive, target);
            		}
        		}
        	}
        }
        return firstPositive;
    }
}
