package com.leetcode.ljia2.solution043;
/**
 * Given two numbers represented as strings, return multiplication of the numbers as a string.
 * Note: The numbers can be arbitrarily large and are non-negative.
 * 
 * **/
public class Solution {
	public String multiply(String num1, String num2) {
		if(num1.equals("0") || num2.equals("0")) return "0";
		if(num1.equals("1")) return num2;
		if(num2.equals("1")) return num1;
		
        if(num2.length() > 1){
        	return Add(multiply(num1, num2.substring(num2.length()-1)), multiply(num1, num2.substring(0, num2.length()-1))+"0"); 
        }else{
        	char[] cnum1 = num1.toCharArray();
        	int inum2 = num2.charAt(0) - '0';        	
        	String result = "";
        	int carryon = 0;
        	for(int cindex1 = cnum1.length-1; cindex1 > -1; cindex1--){
        		int inum1 = cnum1[cindex1] - '0';
        		int digit = inum1*inum2 % 10 + carryon;
        		if(digit > 9){
        			result = String.valueOf(digit - 10) + result;
        			carryon = (int) inum1*inum2/10 + 1;
        		}else{
        			result = String.valueOf(digit) + result;
        			carryon = (int) inum1*inum2/10;
        		}       		
        	}
        	if(carryon > 0){
        		result = String.valueOf(carryon) + result; 
        	}
        	return result;
        }
    }
	public String Add(String num1, String num2){
		char[] cnum1 = num1.toCharArray();
		char[] cnum2 = num2.toCharArray();
		int cindex1 = cnum1.length - 1;
		int cindex2 = cnum2.length - 1;
		String result = "";
		int carryon = 0;
		while(cindex1 > -1 && cindex2 > -1){
			int inum1 = cnum1[cindex1] - '0';
			int inum2 = cnum2[cindex2] - '0';
			int digit = inum1 + inum2 + carryon;
			if(digit > 9){
				result = String.valueOf(digit-10) + result;
				carryon = 1;
			}else{
				result = String.valueOf(digit) + result;
				carryon = 0;
			}
			cindex1--;
			cindex2--;
		}
		if(cindex1 > -1){
			while(cindex1 > -1){
				int digit = cnum1[cindex1] - '0' + carryon;
				if(digit > 9){
					result = String.valueOf(digit - 10) + result;
					carryon = 1;
				}else{
					result = String.valueOf(digit) + result;
					carryon = 0;
				}
				cindex1--;
			}			
		}else if(cindex2 > -1){
			while(cindex2 > -1){
				int digit = cnum2[cindex2] - '0' + carryon;
				if(digit > 9){
					result = String.valueOf(digit - 10) + result;
					carryon = 1;
				}else{
					result = String.valueOf(digit) + result;
					carryon = 0;
				}
				cindex2--;
			}
		}
		
		if(carryon > 0){
			result = String.valueOf(carryon) + result;
		}
		return result;
	}
}
