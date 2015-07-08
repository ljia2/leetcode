package com.leetcode.ljia2.solution224;

import junit.framework.Assert;

import org.junit.Test;

public class SolutionTest {
	@Test
	public void test(){
		Solution solution = new Solution();
		String s = "(1 + (2-4 + 5)) - ((6 +9) -1)";
		Assert.assertEquals(-10, solution.calculate(s));
		
		s = "(1 + (21-4 + 45)) - ((6 +9) -1)";
		Assert.assertEquals(49, solution.calculate(s));

	}
}
