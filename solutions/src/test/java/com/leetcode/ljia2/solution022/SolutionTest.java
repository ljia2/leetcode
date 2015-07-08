package com.leetcode.ljia2.solution022;

import org.junit.Test;

public class SolutionTest {
	@Test
	public void test(){
		Solution s = new Solution();
		int n = 4;
		for(String str : s.generateParenthesis(n)){
			System.out.print(str + ",");
		}
		System.out.println();
		
	}
}
