package com.leetcode.ljia2.solution025;

import org.junit.Test;

import com.leetcode.ljia2.ListNode;
import com.leetcode.ljia2.solution025.Solution;

public class SolutionTest {
	@Test
	public void test(){
		Solution s = new Solution();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		//head.next.next = new ListNode(3);
		
		ListNode newhead = s.reverseKGroup(head, 2);
		while(newhead != null){
			System.out.println(newhead.val);
			newhead = newhead.next;
		}
	}
}
