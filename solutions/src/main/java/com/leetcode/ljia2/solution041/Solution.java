package com.leetcode.ljia2.solution041;
/**
 * 
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 * For example, Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6. 
 * 
 * See the picture: https://leetcode.com/problems/trapping-rain-water/
 * 
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
 * 
 * **/
public class Solution {
	public int trap(int[] height) {
        if(height == null || height.length == 1) return 0;
        int start = 0;
        int trap = 0;
        while(start < height.length){
        	int end = start+1;
        	int substract = height[start];
        	while(end < height.length){
        		if(height[end] < height[start]){
        			substract += height[end];
        			end += 1;
        		}else{
        			break;
        		}
        	}
        	if(end < height.length){
        		int subtrap = (end-start)*Math.min(height[start], height[end]) - substract;
        		trap +=subtrap;
        		start = end;
        	}else{
        		break;
        	}        	
        }
        if(start > 0){
        	return trap;
        }else{
        	return (end-start)*Math.min(height[start], height[end]) - substract;
        }
    }
}
