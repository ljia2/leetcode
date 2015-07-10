package com.leetcode.ljia2.solution047;

import java.util.ArrayList;
import java.util.List;

public class BestSolution {
	public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 1) return results;
        results = generatePermuteUnique(nums, 0);
        return results;
    }
    
    public List<List<Integer>> generatePermuteUnique(int[] nums, int start){
    	List<List<Integer>> results = new ArrayList<List<Integer>>();
    	if(start == nums.length - 1){
    		List<Integer> result = new ArrayList<Integer>();
    		result.add(nums[start]);
    		results.add(result);
    	}else{
    		List<List<Integer>> subresults = generatePermuteUnique(nums, start + 1);
    		for(List<Integer> subresult : subresults){
    			for(int index = 1; index < subresult.size(); index++){
    				List<Integer> result = new ArrayList<Integer>();
    				if(!subresult.get(index-1).equals(Integer.valueOf(nums[start]))){
	    				result.addAll(subresult.subList(0, index));
	    				result.add(nums[start]);
	    				result.addAll(subresult.subList(index, subresult.size()));
	    				results.add(result);
    				}
    			}
    			List<Integer> result = new ArrayList<Integer>();
    			result.add(nums[start]);
    			result.addAll(subresult);
    			results.add(result);
    			if(!subresult.get(subresult.size()-1).equals(Integer.valueOf(nums[start]))){
	    			result = new ArrayList<Integer>();
	    			result.addAll(subresult);
	    			result.add(nums[start]);
	    			results.add(result);
    			}
    		}
    	}
    	return results;
    }
}
