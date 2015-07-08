package com.leetcode.ljia2.solution006;

/**
 * 
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
(you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".

 * **/

public class Solution {
	 public String convert(String s, int numRows) {
        if(s == null || numRows <= 1 || s.length() <= numRows){
			return s;
		}else{
    		String cs = "";
			for(int rowNum  = 0; rowNum < numRows; rowNum++){
				int nextIndex = rowNum;
				boolean down = true;
				while(nextIndex > -1){
					cs += s.charAt(nextIndex);
					down = down? false : true;
					if(rowNum == 0 || rowNum == numRows - 1){
						if(nextIndex + 2*(numRows - 1) > s.length() - 1){
							nextIndex = -1;
						}else{
							nextIndex = nextIndex + 2*(numRows - 1);
						}
					}else{
						if(down){
							if(nextIndex + 2*(numRows - (rowNum + 1)) > s.length() -1){
								nextIndex = 1;
							}else{
								nextIndex += 2*(numRows - (rowNum + 1));
							}
						}else{
							if(nextIndex + 2*rowNum > s.length() -1){
								nextIndex = -1;
							}else{
								nextIndex = nextIndex + 2*rowNum;
							}
						}
					}
				}
			}
			return cs;
		}
    }
}
