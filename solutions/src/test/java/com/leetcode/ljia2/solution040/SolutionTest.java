package com.leetcode.ljia2.solution040;

import org.junit.Test;

public class SolutionTest {
	@Test
	public void test(){
		Solution s = new Solution();
		int[] candidates = new int[]{8, 3, 7, 4};
		int target = 11;
		System.out.println(s.combinationSum2(candidates, target));
	}
}
