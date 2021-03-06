package com.leetcode.ljia2.solution039;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * The same repeated number may be chosen from C unlimited number of times.
 * Note:
 * All numbers (including target) will be positive integers. 
 * Elements in a combination (a1, a2, �� , ak) must be in non-descending order. (ie, a1 �� a2 �� �� �� ak).
 * The solution set must not contain duplicate combinations. 
 * For example, given candidate set 2,3,6,7 and target 7, A solution set is: 
 * [7] 
 * [2, 2, 3] 
 * */

public class Solution {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		HashSet<List<Integer>> tracker = new HashSet<List<Integer>>();
        if(candidates == null || candidates.length == 0) return results;
		if(target <= 0) return results;
		Arrays.sort(candidates);
		for(int candidate : candidates){
			if(candidate <= target){
    			List<List<Integer>> pre_results = combinationSum(candidates, target - candidate);
        		if (pre_results.size() > 0){
            		for(List<Integer> pre_result : pre_results){
        				pre_result.add(candidate);
        				Collections.sort(pre_result);
        				tracker.add(pre_result);
        			}
        		}else{
        			if (candidate == target){
        				List<Integer> result = new ArrayList<Integer>();
        				result.add(candidate);
        				tracker.add(result);
        			}
        		}
			}else{
			    break;
			}
        }
		results.addAll(tracker);
		return results;
    }
}
