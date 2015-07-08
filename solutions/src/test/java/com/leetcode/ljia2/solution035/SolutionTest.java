package com.leetcode.ljia2.solution035;

import org.junit.Test;

import junit.framework.Assert;

public class SolutionTest {
	@Test
	public void test(){
		Solution s = new Solution();
		int [] nums = new int[]{1, 3, 5};
		Assert.assertEquals(1, s.searchInsert(nums, 2));
 	}
}
