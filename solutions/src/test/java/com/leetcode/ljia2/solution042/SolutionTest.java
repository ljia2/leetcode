package com.leetcode.ljia2.solution042;

import org.junit.Test;

import junit.framework.Assert;

public class SolutionTest {
	@Test
	public void test(){
		Solution s = new Solution();
		int[] height = new int[]{4, 2, 3};
		Assert.assertEquals(1, s.trap(height));
	}
}
