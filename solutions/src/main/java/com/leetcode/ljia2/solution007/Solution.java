package com.leetcode.ljia2.solution007;

import java.util.LinkedList;
import java.util.List;

/**
 * Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321
 * */
public class Solution {
	public int reverse(int x) {
		if(x > -10 && x < 10){ return x; }
		
		List<Integer> digits = new LinkedList<Integer>();
		while(x != 0){
			digits.add(x % 10);
			x = x/10;
		}
		int reverse_x = 0;
		for(int digit : digits){
			if(digit > 0){
				if((Integer.MAX_VALUE - digit)/10 < reverse_x){
					//throw new RuntimeException("OverFlow " + x);
					return 0;
				}else{
					reverse_x = reverse_x*10 + digit;
				}
			}else{
				if((Integer.MIN_VALUE - digit)/10 > reverse_x){
					//throw new RuntimeException("UnderFlow " + x);
					return 0;
				}else{
					reverse_x = reverse_x*10 + digit;
				}
			}
		}
		return reverse_x;
	}
}
