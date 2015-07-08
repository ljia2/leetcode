package com.leetcode.ljia2.solution031;

/***
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * The replacement must be in-place, do not allocate extra memory.
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column
 * 1,2,3 ¡ú 1,3,2
 * 3,2,1 ¡ú 1,2,3
 * 1,1,5 ¡ú 1,5,1
 * 
 * Solution: 
 * 1) Scan from the right end to left end, until encourters the first descending index i (swap must happen at i to make sure greater). 
 * 2) from the right end to i, find the first element at j (nums[j] > nums[i]), swap them. 
 * 3) sort from i + 1 to right end in non-descending order to make sure the next greater. 
 * 4) if i == -1, then reverse the whole array. 
 * 
 * 1 2 4   3     ->        1 3 4 2    ->    1 3 2 4. 
 *   i i+1 j  swap(i, j)     j    i   reverse from i+1 to end
 * 5 2 4 3 1 -> 5 3 4 2 1 -> 5 3 1 2 4. 
 * 3 2 1 -> 1 2 3
 * */

public class Solution {
	 public void nextPermutation(int[] nums) {
		 for(int end = nums.length - 2; end > -1; end--){
			 if(nums[end] < nums[end + 1]){
				 for(int swap = nums.length -1 ; swap > end; swap --){
					 if(nums[swap] > nums[end]){
						 int tmp = nums[swap];
						 nums[swap] = nums[end];
						 nums[end] = tmp;
						 
						 for(int i = end + 1; i < nums.length - 1; i++){
							 for(int j = i + 1; j < nums.length; j++){
								 if(nums[i] > nums[j]){
									 tmp = nums[i];
									 nums[i] = nums[j];
									 nums[j] = tmp;
								 }
							 }
						 }
						 return;
					 }
				 }
			 }
		 }
		 
		 int start = 0;
		 int end = nums.length -1;
		 while(start < end){
			 int tmp = nums[start];
			 nums[start] = nums[end];
			 nums[end] = tmp;
			 start += 1;
			 end -= 1;
		 }
	 }
}
