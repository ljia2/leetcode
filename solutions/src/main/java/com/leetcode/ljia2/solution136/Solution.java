package com.leetcode.ljia2.solution136;

import java.util.HashSet;
/**
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * 
 **/
public class Solution {
	public int singleNumber(int[] nums){
		HashSet<Integer> intcount = new HashSet<Integer>();
        for(int i : nums){
            if(intcount.contains(i)){
            	intcount.remove(i);
            }else{
            	intcount.add(i);
            }
        }
        return intcount.iterator().next();
	}
}
