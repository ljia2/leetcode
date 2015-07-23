package com.leetcode.ljia2.solution064;
/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time.
 * 
 * **/
public class Solution {
	public int minPathSum(int[][] grid) {
		if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
		int rowNum = grid.length;
		int colNum = grid[0].length;
		int[][] pathMinSum = new int[rowNum][colNum];
		for(int j = colNum-1; j>-1; j--){
			for(int i = rowNum-1; i>-1; i--){
				if(i == rowNum-1 && j == colNum-1){
					pathMinSum[i][j] = grid[i][j];
				}else if(i == rowNum-1){
					pathMinSum[i][j] = grid[i][j] + pathMinSum[i][j+1];
				}else if(j == colNum-1){
					pathMinSum[i][j] = grid[i][j] + pathMinSum[i+1][j];
				}else{
					pathMinSum[i][j] = grid[i][j] + Math.min(pathMinSum[i][j+1], pathMinSum[i+1][j]);
				}
			}
		}
		return pathMinSum[0][0];
    }
}
