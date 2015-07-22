package com.leetcode.ljia2.solution189;
/***
 * Rotate an array of n elements to the right by k steps. For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 * Note:
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 * 
 * 
 * Solution: 
 * **/
public class Solution {
	public void rotate(int[] nums, int k) {
        k = k % nums.length;
        // do right shift k times
        for(int startindex = 0; startindex < k; startindex++){
        	int sourceindex = startindex;
        	int swapsource = nums[sourceindex];
        	int targetindex = (sourceindex + k) % nums.length;
        	while(targetindex != startindex){
        		int tmp = nums[targetindex];
        		nums[targetindex] = swapsource;
        		swapsource = tmp;
        		sourceindex = targetindex;
        		targetindex = (sourceindex + k) % nums.length;
        	}
        	// do the last swap
        	nums[targetindex] = swapsource;
        }
    }
}
