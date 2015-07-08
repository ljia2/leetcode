package com.leetcode.ljia2.solution015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.
 * Note:
 * Elements in a triplet (a,b,c) must be in non-descending order. (i.e., a ¡Ü b ¡Ü c)
 * The solution set must not contain duplicate triplets. 
 * For example, given array S = {-1 0 1 2 -1 -4},
 * A solution set is:
 * (-1, 0, 1)
 * (-1, -1, 2)
 * 
 * Algorithm: we first sorted nums, and then we iterates for each element a in nums to find b + c = 0 -a
 * 			2) we setup two ptrs start_ptr (b > a) and eng_ptr (c > b > a) where start_ptr points to the element next to a and end_ptr to the second last element
 * 			2.1) if a + b + c == 0, we move start_ptr and end_ptr toward to each other
 * 			2.1) if a + b + c < 0, we need to move start_ptr to find a bigger b' where a + b' + c = 0
 * 			2.3) if a + b + c > 0, we need to move end_ptr to find a smaller c' where a + b + c' = 0
 *  Note: we can always set the start_ptr to the element next to a. 
 *  If we set start_ptr to a element (a') before a, any results involving start_ptr (< a) before a have been found when we set a = a' already. 
 *  
 *  Note: we set eng_ptr to the second last element, because when a is set to the last element, we get all results involving the last element already.
 *  
 *  Note: when a > 0, we can stop, because c > b > c > 0, there is no solution. 
 * **/
public class Solution {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		if(nums == null || nums.length < 3){
			return results;
		}
		// We use HashSet.add() to gurantee the uniqueness of the results
		HashSet<List<Integer>> tracker = new HashSet<List<Integer>>();
		// We first sorted nums, and then we iterates for each element a in nums to find b + c = 0 - a
		Arrays.sort(nums);
		int last_target_ptr = -1;
		for(int target_ptr = 0; target_ptr < nums.length; target_ptr++){			
			// when a > 0, we can stop, because c > b > a > 0, there is no solution. 
			if(nums[target_ptr] > 0){ 
				break; 
			}
			// skip the same element as nums[target_ptr]
			if(last_target_ptr > -1){
				if(nums[last_target_ptr] == nums[target_ptr]){
					last_target_ptr = target_ptr;
					continue;
				}
			}
			
			// we set start_ptr and target_ptr as b and c to make sure c > b > a. 
			// set the start_ptr to the element next to a to make sure b > c. 
			int start_ptr = target_ptr + 1;
			// set end_ptr to the last element
			int end_ptr = nums.length - 1;
			while(start_ptr < end_ptr){
				if(nums[start_ptr] + nums[end_ptr] + nums[target_ptr] == 0){
					List<Integer> result = new ArrayList<Integer>();
					result.add(nums[target_ptr]);
					result.add(nums[start_ptr]);
					result.add(nums[end_ptr]);
					if(tracker.add(result)){
						results.add(result);
					}
					// first move start_ptr forward, and then skip the same element as nums[start_ptr] by keeping moving
					start_ptr += 1;
					while(start_ptr < end_ptr && nums[start_ptr-1] == nums[start_ptr]){
						start_ptr += 1;
					}
					// first move end_ptr backward, and then skip the same element as nums[end_ptr] by keeping moving
					end_ptr -= 1;
					while(start_ptr < end_ptr && nums[end_ptr] == nums[end_ptr+1]){
						end_ptr -= 1;
					}
				}else if(nums[start_ptr] + nums[target_ptr] + nums[end_ptr] < 0){
					// first move start_ptr forward, and then skip the same element as nums[start_ptr] by keeping moving
					start_ptr += 1;
					while(start_ptr < end_ptr && nums[start_ptr-1] == nums[start_ptr]){
						start_ptr += 1;
					}
				}else if(nums[start_ptr] + nums[target_ptr] + nums[end_ptr] > 0){
					// first move end_ptr backward, and then skip the same element as nums[end_ptr] by keeping moving
					end_ptr -= 1;
					while(start_ptr < end_ptr && nums[end_ptr] == nums[end_ptr+1]){
						end_ptr -= 1;
					}
				}
			}
			
			last_target_ptr = target_ptr;
		}
        return results;
    }
}
