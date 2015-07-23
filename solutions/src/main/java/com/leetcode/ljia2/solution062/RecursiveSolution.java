package com.leetcode.ljia2.solution062;
/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * How many possible unique paths are there?
 * see: https://leetcode.com/problems/unique-paths/
 * **/
public class RecursiveSolution {
	public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1)
        	return 0;
        return uniquePaths(m, n-1) + uniquePaths(m-1, n);
    }
}
