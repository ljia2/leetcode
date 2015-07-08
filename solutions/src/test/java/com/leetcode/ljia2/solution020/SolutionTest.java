package com.leetcode.ljia2.solution020;

import org.junit.Test;

import junit.framework.Assert;

public class SolutionTest {
	@Test
	public void test(){
		Solution s = new Solution();
		String test = "()";
		Assert.assertEquals(true, s.isValid(test));
	}
}
