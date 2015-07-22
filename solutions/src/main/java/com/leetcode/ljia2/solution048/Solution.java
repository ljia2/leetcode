package com.leetcode.ljia2.solution048;

public class Solution {
	public void rotate(int[][] matrix) {
		int n = matrix.length;
		int maxLayerIndex = n % 2 == 0? n/2 : n/2 + 1;
		
		for(int layer = 0; layer < maxLayerIndex; layer++){
		
			int startrow = layer;
			int endrow = n - 1 - layer;
			int startcolumn = layer;
			int endcolumn = n - 1 - layer;
			
			if(startrow == endrow && startcolumn == endcolumn){
				break;
			}else{
				// matrix[startrow][j] => tmp
				int[] tmp = new int[endrow - startrow];
				int index = 0;
				for(int j = startcolumn; j < endcolumn; j++){
					tmp[index] = matrix[startrow][j];
					index++;
				}
			
				// left column to start row rotately. 
				for(int j = startcolumn ; j < endcolumn; j++){
					matrix[startrow][j] = matrix[n - 1 - j][startcolumn];					
				}
				// end row to left column rotately. 
				for(int i = endrow; i > startrow; i--){
					matrix[i][startcolumn] = matrix[endrow][i];
				}
				
				for(int j = endcolumn; j > startcolumn; j--){
					matrix[endrow][j] = matrix[n-1-j][endcolumn];
				}
				
				index = 0;
				for(int i = startrow; i < endrow; i++){
					matrix[i][endcolumn] = tmp[index];
					index++;
				}
			}
		}
    }
	
	/*
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
	*/
}
