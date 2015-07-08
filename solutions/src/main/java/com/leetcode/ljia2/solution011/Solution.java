package com.leetcode.ljia2.solution011;
/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). 
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * Note: You may not slant the container.
 * 
 * Solution: 1) calculate the max_area as that between left most and right most lines.
 * 			 2) if left most is shorter, scan from left to right to find a higher line than the left most before encouter the right most line
 * 				2.1) calculate the area (might bigger than max_area) and record max_area
 * 			 3) if right most line is shorter, scan from right to left to find a higher line than the right most line before encounter the left most line
 * 				3.1) calculate the area (might bigger than max_area) and record max_area
 * 			 4) if the left line does not meet the right line (repeat steps 2) and 3)). 
 * 
 * **/
public class Solution {
	public int maxArea(int[] height) {
        if(height == null || height.length == 0 || height.length == 1) return 0;
        int start = 0;
        int end = height.length - 1;
        int max_area = (end - start)*Math.min(height[start], height[end]);
        while(start <= end){
        	if(height[start] < height[end]){
        		int newstart = start+1;
        		while(newstart <= end){
        			if(height[start] >= height[newstart]){
        				newstart += 1;
        			}else{
        				break;
        			}
        		}
        		if(newstart <= end){
	        		int area = (end - newstart)*Math.min(height[newstart], height[end]);
	        		if(area > max_area){
	        			max_area = area;
	        		}
	        		start = newstart;
        		}else{
        			break;
        		}
        	}else{
        		int newend = end-1;
        		while(newend >= start){
        			if(height[newend] <= height[end]){
        				newend -= 1;
        			}else{
        				break;
        			}
        		}
        		if(newend >= start){
	        		int area = (newend - start)*Math.min(height[start], height[newend]);
	        		if(area > max_area){
	        			max_area = area;
	        		}
	        		end = newend;
        		}else{
        			break;
        		}
        	}        	
        }
        return max_area;
    }
}
