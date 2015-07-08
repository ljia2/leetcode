package com.leetcode.ljia2.solution029;

/**
 * Divide two integers without using multiplication, division and mod operator. If it is overflow, return MAX_INT.
 * 
 * Solution: 
 * 	Step1: keep shifting right of divisor (multiple by two) until divisor is just smaller than dividend.
 *     		1.1: record how many times of shifts s which is equivalent to subtracting 2^s times of divisor from divident 
 *  Step2: update the dividend as dividend - 2^s*divisor
 *  Step3: repeat the Steps 1 and 2 until we get 0
 *  
 *  Trick1: Avoid Math.abs since if x = Integer.MIN_VALUE, Math.abs(x) underflows. 
 *  Trick2: Find the sign of the results and map dividend and divisor to negative space, finally use the algorithm above.
 *  Negative Space is -1 to -2147483648  Bigger than Positive Space 1 to 2147483647
 *  
 *  Note: shift priority is lower than +, -, *, /, so need parenthesis
 *  m - n << 2 == (m - n) << 2 != m - (n<<2)
 *  
 * */

public class Solution {
	public int divide(int dividend, int divisor) {
		if(divisor == 0){
			return Integer.MAX_VALUE;
		}
		
		if(dividend == Integer.MIN_VALUE && divisor == -1){
			return Integer.MAX_VALUE;
		}
				
		boolean negative = false;
		if((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)){
			negative = true;
		}
		
		dividend = dividend > 0? 0 - dividend : dividend;
		divisor = divisor > 0? 0 - divisor : divisor;
		// all negative
		int result = 0;
		while(dividend <= divisor){
			int newdivisor = divisor;
			int counter = 1;
			// prevent newdivisor<<1 underflow: newdivisor >= Integer.MIN_VALUE/2 
			while(newdivisor >= Integer.MIN_VALUE/2 && dividend - (newdivisor<<1) < divisor){
				newdivisor = newdivisor<<1;
				counter = counter<<1;
			}
			result += counter;
			dividend -= newdivisor;
		}
		return negative? 0 - result : result;
	}
}
