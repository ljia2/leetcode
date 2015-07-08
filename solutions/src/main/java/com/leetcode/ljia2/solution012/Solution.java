package com.leetcode.ljia2.solution012;
/**
 * Given an integer, convert it to a roman numeral.
 * Input is guaranteed to be within the range from 1 to 3999. 
 * 
 * Roman numerals, as used today, are based on seven symbols:[1]
 * 
 * I, II, III, IV, V, VI, VII, VIII, IX, X.
 * 
 * Symbol	Value
 * I	1
 * V	5
 * X	10
 * L	50
 * C	100
 * D	500
 * M	1,000
 * 
 * Rules:
 * 1) I placed before V or X indicates one less, so four is IV (one less than five) and nine is IX (one less than ten)
 * 2) X placed before L or C indicates ten less, so forty is XL (ten less than fifty) and ninety is XC (ten less than a hundred)
 * 3) C placed before D or M indicates a hundred less, so four hundred is CD (a hundred less than five hundred) and nine hundred is CM (a hundred less than a thousand)
 * 
 * 
 * **/
public class Solution {
	public String intToRoman(int num) {
        String romanNum = "";
		int base = 1;
        while(num > 0){
        	romanNum = intDigit2RomanDigit(num % 10, base) + romanNum;
        	num = num/10;
        	base = base*10;
        }
        return romanNum;
    }
	
	public String intDigit2RomanDigit(int digit, int base){
		String romanDigit = "";
		String oneDigit = "", fiveDigit = "", tenDigit = "";
		switch(base){
			case 1000:
				oneDigit = "M";
				break;
			case 100:
				oneDigit = "C";
				fiveDigit = "D";
				tenDigit = "M";
				break;
			case 10:
				oneDigit = "X";
				fiveDigit = "L";
				tenDigit = "C";
				break;
			case 1:
				oneDigit = "I";
				fiveDigit = "V";
				tenDigit = "X";
				break;
			default:
				break;
		}
		
		if(digit <= 3){
			while(digit > 0){
				romanDigit += oneDigit;
				digit -= 1;
			}
		}else if(digit == 4){
			romanDigit = oneDigit + fiveDigit;
		}else if(digit == 5){
			romanDigit = fiveDigit;
		}else if(digit < 9){
			romanDigit = fiveDigit;
			while(digit > 5){
				romanDigit += oneDigit;
				digit -= 1;
			}
		}else if(digit == 9){
			romanDigit = oneDigit + tenDigit;
		}
		
		return romanDigit;
	}
}
