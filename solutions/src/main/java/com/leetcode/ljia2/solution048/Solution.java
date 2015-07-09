package com.leetcode.ljia2.solution048;

public class Solution {
	public void rotate(int[][] matrix) {
		int n = matrix.length;
        for(int layer = 0; layer <= (int) n/2; layer++){
        	rotateLayer(matrix, layer);
        }
    }
	public void rotateLayer(int[][] matrix, int layer){
		int n = matrix.length;
		int row1 = layer;
    	int row2 = n-1-layer;
    	int column1 = layer;
    	int column2 = n-1-layer;
		
    	//store row1 to tmp
		int[] tmp = new int[column2-column1+1];
		int index = 0;
		for(int i = column1; i <= column2; i++){
			tmp[index] = matrix[row1][i];
			index++;
		}
		
		// move column1 to row1 (pay attention!!!)
		for(int i = column1; i<= column2; i++){
			matrix[row1][i] = matrix[n-1-i][column1];
		}
		
		// move row2 to column1
		for(int i = row1; i <= row2; i++){
			matrix[i][column1] = matrix[row2][i];
		}
		// move column2 to row2 (pay attention !!!)
		for(int i = column1; i <= column2; i++){
			matrix[row2][i] = matrix[n-1-i][column2];
		}
		
		// move tmp to column2
		index = 0;
		for(int i = row1; i <= row2; i++){
			matrix[i][column2] = tmp[index];
			index++;
		}
	}
}
