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

observation

0	step=[10]		10		[10]		20
1	step=[8]	9[2]11  [8]			19[2]21
2	step=[6]8	[4]	12			18		22
3step=[4]7	[6]		13		17			23
4 [2]6      [8]		14	16				24
5	step=[10]		15		[10]		25



 * **/
public class BestSolution {
	public String convert(String s, int numRows){
		if(s == null || numRows == 1 || numRows >= s.length()){
			return s;
		}else{
			StringBuffer cs = new StringBuffer();
			for(int rowNum = 1; rowNum < numRows + 1; rowNum++){
				int position = rowNum - 1;
				if(rowNum == 1 || rowNum == numRows){
					int step = 2*(numRows-1);
					while(position < s.length()){
						cs.append(s.charAt(position));
						position = position + step;
					}
				}else{
					int step = 2*(numRows - rowNum);
					while(position < s.length()){
						cs.append(s.charAt(position));
						position += step;
						step = 2*(numRows-1) - step;
					}
				}
			}
			return cs.toString();
		}
	}
}
