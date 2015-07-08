package com.leetcode.ljia2.solution029;

import org.junit.Test;

public class SolutionTest {
	@Test
	public void test(){
		int n = 10;
		int m = 2;
		System.out.println(n - m<<2);
		System.out.println(n - (m<<2));
		Solution s = new Solution();
		int dividend = Integer.MAX_VALUE;
		int divisor = 2;
		System.out.println(s.divide(dividend, divisor));
		dividend = 1;
		divisor = -1;
		System.out.println(s.divide(dividend, divisor));
	}
}
