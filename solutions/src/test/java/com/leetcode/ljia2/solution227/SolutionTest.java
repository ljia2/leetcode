package com.leetcode.ljia2.solution227;

import junit.framework.Assert;

import org.junit.Test;

import com.leetcode.ljia2.solution227.Solution;

public class SolutionTest {
	@Test
	public void test(){
		Solution solution = new Solution();
		String s = "1 + 1";
		Assert.assertEquals(-10, solution.calculate(s));
	}
}
