package com.leetcode.ljia2.solution067;
/**
 * Given two binary strings, return their sum (also a binary string).
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 * **/
public class Solution {
	public String addBinary(String a, String b) {
        if(a == null || b == null || a.length() == 0 || b.length() == 0) return new String();
        char[] alist = a.toCharArray();
        char[] blist = b.toCharArray();
        StringBuilder result = new StringBuilder();
        int aindex = alist.length-1;
        int bindex = blist.length-1;
        int digit, carryon = 0;
        while(aindex > -1 && bindex > -1){
        	digit = alist[aindex] - '0';
        	digit += blist[bindex] - '0';
        	digit += carryon;
        	result.append(digit % 2);
        	if(digit >= 2){ carryon = 1; }else{ carryon = 0; }       	
        	aindex -= 1;
        	bindex -= 1;
        }
        
        while(aindex > -1){
        	digit = alist[aindex] - '0' + carryon;
        	result.append(digit % 2);
        	if(digit == 2){ carryon = 1; }else{ carryon = 0; }
        	aindex -= 1;
        }
        
        while(bindex > -1){
        	digit = blist[bindex] - '0' + carryon;
        	result.append(digit % 2);
        	if(digit == 2){ carryon = 1; }else{ carryon = 0; }
        	bindex -= 1;
        }
       
        // do not forget the last carryon !!!
        if(carryon == 1){ result.append(1); }
        return result.reverse().toString();
    }
}
