package com.leetcode.ljia2.solution042;
/**
 * 
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 * For example, Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6. 
 * 
 * See the picture: https://leetcode.com/problems/trapping-rain-water/
 * 
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. 
 * Thanks Marcos for contributing this image!
 * 
 * Solution (similar to max_area problem of Container With Most Water
 * 	1) set Start to the first height and End to the last height
 *  2) if height[Start] < height[End]
 *  	2.1) keep moving forward to find a heigt (Newend) higher or same as End before encouters End. 
 *      2.2) if Newend does not bypass End, 
 *      		2.2.1) add the incremental trap between Start and NewEnd: (Newend - Start - 1)*min(height[Start], height[Newend] - block (block is the sum of heights between Start and Newend exclusively).
 *      		2.2.2) reset Start as Newend
 *      2.3) return the trap (since you have calculate all traps)
 *  3) otherwise (height[Start] >= height[End]):  
 *  	3.1) keep moving backward to find a height (Newstart) higher or same as End before encouter Start.
 *      3.2) if Newstart does not bypass Start, 
 *      		2.2.1) add the incremental trap between Newstart and End: (End - Newstart - 1)*min(height[Newstart], height[End] - block (block is the sum of heights between Newstart and End exclusively).
 *      		2.2.2) reset End as Newstart
 *      3.3) return the trap (since you have calculate all traps)
 *  4) repeat step 2) or step 3 until Start and End bypass each other.
 * 
 * **/
public class Solution {
	public int trap(int[] height) {
        if(height == null || height.length == 1) return 0;
        int start = 0;
        int end = height.length -1;
        int trap = 0;
        while(start <= end){
        	if(height[start] < height[end]){
        		int newend = start+1;
        		int block = 0;
        		while(newend <= end){
        			if(height[newend] < height[start]){
        				block += height[newend];
        				newend += 1;        				
        			}else{
        				break;
        			}
        		}
        		if(newend <= end){
        			trap += (newend - start - 1)*Math.min(height[start], height[newend]) - block;
        			start = newend;
        		}else{
        			break;
        		}
        	}else{
        		int newstart = end - 1;
        		int block = 0;
        		while(newstart >= start){
        			if(height[newstart] < height[end]){
        				block += height[newstart];
        				newstart -= 1;
        			}else{
        				break;
        			}
        		}
        		if(newstart >= start){
        			trap += (end - newstart - 1)*Math.min(height[newstart], height[end]) - block;
        			end = newstart;
        		}else{
        			break;
        		}
        	}        	      	
        }   
        
       return trap; 
    }
}
