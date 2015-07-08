package com.leetcode.ljia2.solution024;

import com.leetcode.ljia2.ListNode;

public class Solution {
	public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
        	return head;
        }else{
        	ListNode result = swapPairs(head.next.next);
        	
        	ListNode tmp = head.next;
        	head.next = result;
        	tmp.next = head;
        	
        	return tmp;
        }
    }
}
