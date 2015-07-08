package com.leetcode.ljia2.solution036;

import java.util.HashSet;

/**
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'
 * 
 * Note: A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
 * **/
public class Solution {
	 public boolean isValidSudoku(char[][] board) {
		 return rowValid(board) && columnValid(board) && squareValid(board);
	 }
	 public boolean rowValid(char[][] board){
		 HashSet<Integer> rowhash = new HashSet<Integer>();
		 for(int row = 0; row < board.length; row++){
			 rowhash.clear();
			 for(char c : board[row]){
				 if (c == '.'){
					 continue;
				 }else{
					 int num = c - '0';
					 if(num >= 1 && num <= 9){
						 if(!rowhash.add(num)){
							 return false;
						 }
					 }else{
						 return false;
					 }
				 }
			 }
		 }
		 return true;
	 }
	 
	 public boolean columnValid(char[][] board){
		 HashSet<Integer> columnhash = new HashSet<Integer>();
		 for(int column = 0; column < board[0].length; column++){
			 columnhash.clear();
			 for(int row = 0; row < board.length; row++){
				 char c = board[row][column];
				 if(c == '.') continue;
				 int num = c - '0';
				 if(num >= 1 && num <= 9){
					 if(!columnhash.add(num)){
						 return false;
					 }
				 }else{
					 return false;
				 }
			 }
		 }
		 return true;
	 }
	  
	 public boolean squareValid(char[][] board){
		 HashSet<Integer> squarehash = new HashSet<Integer>();
		 for(int row = 0; row < board.length-1; row += 3){
			 for(int column = 0; column < board[0].length-1; column += 3){
				 squarehash.clear();
				 for(int i = row; i < row + 3; i++){
					 for(int j = column; j < column+3; j++){
						 char c = board[i][j];
						 if(c == '.') continue; 
						 int num = c - '0';
						 if(num >= 1 && num <=9){
							 if(!squarehash.add(num)){
								 return false;
							 }
						 }else{
							 return false;
						 }
					 }
				 }
			 }
		 }
		 return true;
	 }
}
