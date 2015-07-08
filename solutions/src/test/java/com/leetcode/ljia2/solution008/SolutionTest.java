package com.leetcode.ljia2.solution008;

import junit.framework.Assert;

import org.junit.Test;

public class SolutionTest {
	@Test
	public void test(){
		Solution s = new Solution();
		String str = "+1";
		Assert.assertEquals(1, s.myAtoi(str));
	}
}
