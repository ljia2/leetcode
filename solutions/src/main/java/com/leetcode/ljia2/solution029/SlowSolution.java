package com.leetcode.ljia2.solution029;

/**
 * Divide two integers without using multiplication, division and mod operator. If it is overflow, return MAX_INT.
 * 
 * Solution: 
 * 	keep substracting divisor from divident. The speed is two slow.
 * */

public class SlowSolution {
	public int divide(int dividend, int divisor) {
		if(dividend == Integer.MAX_VALUE && divisor == -1){
        	return Integer.MAX_VALUE;
        }
        if(divisor == 0){
        	return Integer.MAX_VALUE;
        }
        if(dividend == 0){
        	return 0;
        }
        if(divisor == 1){
            return dividend;
        }else if(divisor == -1){
            return 0 - dividend;
        }
        
        int dividend_abs = Math.abs(dividend);
        int divisor_abs = Math.abs(divisor);
        int result = 0;
        while(dividend_abs > 0){
        	dividend_abs -= divisor_abs;
        	result += 1;
        }
        if((dividend > 0 && divisor < 0) || (dividend > 0 && divisor < 0)){
        	return 0 - result;
        }else{
        	return result;
        }
    }
}
