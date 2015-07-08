package com.leetcode.ljia2.solution050;

public class Solution {
	public double myPow(double x, int n) {
		if(n == 0){
			return 1;
		}else{
			double rs = myPow(x, (int) n/2);
			if(n % 2 == 0){
				return rs*rs;
			}else{
				if(n > 0){
					return x*rs*rs;
				}else{
					return rs*rs/x;
				}
			}
		}
	}
}
