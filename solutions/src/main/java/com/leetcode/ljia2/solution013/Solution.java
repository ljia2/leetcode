package com.leetcode.ljia2.solution013;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
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
 * Solution: scan the roman num from right to left, when we encounter a roman digit d , we check the prioprity of the next roman digit d':
 * 1) if Pr(d) >= P(d'), then add d*priority to result;
 * 2) if Pr(d) < P(d'), then substract d*priority and then add d'*priority
 * 
 * 
 * **/
public class Solution {
	public int romanToInt(String s) {
        // initialize a hashmap
		HashMap<Character, Integer> romanDigit2Base = new HashMap<Character, Integer>(){
        	{
        		put('I', 1);
        		put('V', 5);
        		put('X', 10);
        		put('L', 50);
        		put('C', 100);
        		put('D', 500);
        		put('M', 1000);       		
        	}
        };
        int result = 0;
        
        int index = 0;
        while(index < s.length()){
        	if(index < s.length() - 1){
	        	if(romanDigit2Base.get(s.charAt(index)) >= romanDigit2Base.get(s.charAt(index+1))){
	        		result += romanDigit2Base.get(s.charAt(index));
	        		index += 1;
	        	}else{
	        		result += romanDigit2Base.get(s.charAt(index+1)) - romanDigit2Base.get(s.charAt(index));
	        		index += 2;
	        	}
        	}else{
        		result += romanDigit2Base.get(s.charAt(index));
        		index += 1;
        	}
        }
        return result;
    }
}
