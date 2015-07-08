package com.leetcode.ljia2.solution048;

import org.junit.Test;

public class SolutionTest {
	@Test
	public void test(){
		Solution s = new Solution();
		int[][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		s.rotate(matrix);
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				System.out.print(matrix[i][j] + ",");
			}
			System.out.println();
		}
	}
}
