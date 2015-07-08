package com.leetcode.ljia2.solution007;

import junit.framework.Assert;

import org.junit.Test;

public class SolutionTest {
	@Test
	public void test(){
		Solution s = new Solution();
		Assert.assertEquals(-321, s.reverse(-123));
		Assert.assertEquals(321, s.reverse(123));
	}
}
