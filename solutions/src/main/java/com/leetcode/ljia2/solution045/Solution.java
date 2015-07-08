package com.leetcode.ljia2.solution045;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Given a collection of numbers, return all possible permutations.
 * For example,
 * [1,2,3] have the following permutations:
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 * 
 * **/
public class Solution {
	public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        HashSet<List<Integer>> tracker = new HashSet<List<Integer>>();
        if(nums == null || nums.length == 0) return results;
        
        for(int index = 0; index < nums.length; index++){
        	
        }
        	
    }
}
