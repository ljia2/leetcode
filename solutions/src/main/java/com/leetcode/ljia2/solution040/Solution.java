package com.leetcode.ljia2.solution040;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * Each number in C may only be used once in the combination.
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, ¡­ , ak) must be in non-descending order. (ie, a1 ¡Ü a2 ¡Ü ¡­ ¡Ü ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
 * A solution set is: 
 * [1, 7] 
 * [1, 2, 5] 
 * [2, 6] 
 * [1, 1, 6] 
 * 
 * ***/

public class Solution {
	 public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        HashSet<List<Integer>> tracker = new HashSet<List<Integer>>();
        if(candidates == null || candidates.length == 0) return results;
        if (target == 0) return results;
        Arrays.sort(candidates);
        for(int index = 0; index < candidates.length; index++){
        	int candidate = candidates[index];
        	if(candidate <= target){
        		List<List<Integer>> preresults = combinationSum(candidates, target - candidates[index], index+1);
        		if(preresults.size() > 0){
        			for(List<Integer> preresult : preresults){
        				preresult.add(candidate);
        				Collections.sort(preresult);
        				tracker.add(preresult);
        			}
        		}else{
        			if(candidates[index] == target){
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
	 
	 public List<List<Integer>> combinationSum(int[] candidates, int target, int start){
		 List<List<Integer>> results = new ArrayList<List<Integer>>();
	     HashSet<List<Integer>> tracker = new HashSet<List<Integer>>();
	     if(candidates == null || candidates.length == 0) return results;
	     if (target == 0) return results;
	     for(int index = start; index < candidates.length; index++){
	    	 int candidate = candidates[index];
	    	 if(candidate <= target){
	    		 List<List<Integer>> preresults = combinationSum(candidates, target - candidate,index+1);
	    		 if(preresults.size() > 0){
	    			 for(List<Integer> preresult : preresults){
	    				 preresult.add(candidate);
	    				 Collections.sort(preresult);
	    				 tracker.add(preresult);
	    			 }
	    		 }else{
	    			 if(candidate == target){
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
