package com.leetcode.ljia2.solution054;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * For example,
 * Given the following matrix:
 * [
 * 	[ 1, 2, 3 ],
 * 	[ 4, 5, 6 ],
 * 	[ 7, 8, 9 ]
 * ]
 * 
 * You should return [1,2,3,6,9,8,7,4,5].
 * 
 * Note m and n are different
 * 
 * ***/
public class Solution {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> results = new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0) return results;
        int m = matrix.length;
        int n = matrix[0].length;
        if(m == 1){
        	for(int j = 0; j < n; j++){
        		results.add(matrix[m-1][j]);
        	}
        }else if(n == 1){
        	for(int i = 0; i < m; i++){
        		results.add(matrix[i][n-1]);
        	}
        }else{
        	// how many layers for m*n matrix
        	int maxLayerIndex = Math.min(m, n) % 2 == 0 ? Math.min(m, n)/2 : Math.min(m, n)/2 + 1;
	        
        	for(int layer = 0; layer < maxLayerIndex; layer++){
	        	int startrow = layer; 
	        	int endrow = m - layer - 1;
	        	int startcolumn = layer;
	        	int endcolumn = n - layer - 1;
	        	
	        	if(startrow == endrow){
	        		for(int j = startcolumn; j <= endcolumn; j++){
	        			results.add(matrix[startrow][j]);
	        		}
	        	}else if(startcolumn == endcolumn){
	        		for(int i = startrow; i <= endrow; i++){
	        			results.add(matrix[i][startcolumn]);
	        		}
	        	}else{
	        		for(int j = startcolumn; j < endcolumn; j++){
	        			results.add(matrix[startrow][j]);
	        		}
	        		for(int i = startrow; i < endrow; i++){
	        			results.add(matrix[i][endcolumn]);
	        		}
	        		for(int j = endcolumn; j > startcolumn; j--){
	        			results.add(matrix[endrow][j]);
	        		}
	        		for(int i = endrow; i > startrow; i--){
	        			results.add(matrix[i][startcolumn]);
	        		}
	        	}
	        }
        	
        }
        return results;
    }
}
