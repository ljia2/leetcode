package com.leetcode.ljia2.solution063;

public class Solution {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rowNum = obstacleGrid.length;
        int colNum = obstacleGrid[0].length;
		int[][] pathCount = new int[rowNum][colNum];
        for(int j = colNum-1; j >= 0; j--){
        	for(int i = rowNum-1; i>=0; i--){
        		if(obstacleGrid[i][j] == 1){
        			pathCount[i][j] = 0;
        		}else{
        			if(i == rowNum-1 && j == colNum-1){
        				pathCount[i][j] = 1;
        			}else if(i == rowNum-1){
        				pathCount[i][j] = pathCount[i][j+1];
        			}else if(j == colNum-1){
        				pathCount[i][j] = pathCount[i+1][j];
        			}else{
        				pathCount[i][j] = pathCount[i+1][j] + pathCount[i][j+1];
        			}
        		}
        	}
        }
        return pathCount[0][0];
    }
}
