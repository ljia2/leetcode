package com.leetcode.ljia2.solution023;

import org.junit.Test;

import com.leetcode.ljia2.ListNode;

public class SolutionTest {
	@Test
	public void test(){
		Solution s = new Solution();
		ListNode[] lists = new ListNode[2];
		lists[0] = new ListNode(1);
		lists[1] = new ListNode(0);
		ListNode results = s.mergeKLists(lists);
		while(results != null){
			System.out.println(results.val);
			results = results.next;
		}
	}
}
