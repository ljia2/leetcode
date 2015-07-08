package com.leetcode.ljia2.solution038;

import org.junit.Test;

public class SolutionTest {
	@Test
	public void test(){
		Solution s = new Solution();		
		for(int n = 1; n < 10; n++){
			System.out.println(s.countAndSay(n));
		}
	}
}
