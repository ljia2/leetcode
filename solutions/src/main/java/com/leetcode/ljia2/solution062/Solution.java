package com.leetcode.ljia2.solution062;

public class Solution {
	public int uniquePaths(int m, int n) {
		int[][] pathCount = new int[m][n];
		for(int j = n-1; j >= 0; j--)
			for(int i = m-1; i >= 0; i--)
				if(i == m-1 || j == n-1){
					pathCount[i][j] = 1;
				}else{
					pathCount[i][j] = pathCount[i+1][j] + pathCount[i][j+1];
				}
		return pathCount[0][0];		
	}
}
