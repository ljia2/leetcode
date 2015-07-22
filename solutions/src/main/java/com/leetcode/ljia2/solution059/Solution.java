package com.leetcode.ljia2.solution059;
/***
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * For example,
 * Given n = 3,
 * You should return the following matrix:
 * [
 * 	[ 1, 2, 3 ],
 * 	[ 8, 9, 4 ],
 * 	[ 7, 6, 5 ]
 * ]
 * 
 * **/
public class Solution {
	public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int maxLayerIndex = n % 2 == 0 ? n/2 : n/2 + 1;
        int startvalue = 0;
        for(int layer = 0; layer < maxLayerIndex; layer++){
        	int startrow = layer;
        	int endrow = n - layer - 1;
        	int startcolumn = layer;
        	int endcolumn = n - layer - 1;
        	
        	if(startrow == endrow && startcolumn == endcolumn){
        		matrix[startrow][endrow] = startvalue + 1;
        		startvalue += 1;
        	}else{
        		for(int j = startcolumn; j < endcolumn; j++){
        			matrix[startrow][j] = startvalue + 1;
        			startvalue += 1;
        		}
        		for(int i = startrow; i < endrow; i++){
        			matrix[i][endcolumn] = startvalue + 1;
        			startvalue += 1;
        		}
        		for(int j = endcolumn; j > startcolumn; j--){
        			matrix[endrow][j] = startvalue + 1;
        			startvalue += 1;
        		}
        		for(int i = endrow; i > startrow;i--){
        			matrix[i][startcolumn] = startvalue + 1;
        			startvalue += 1;
        		}
        	}        	
        }
        return matrix;
    }
}
