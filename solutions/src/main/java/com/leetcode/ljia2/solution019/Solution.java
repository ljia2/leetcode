package com.leetcode.ljia2.solution019;

import com.leetcode.ljia2.ListNode;

/**
 * Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.
 * **/
public class Solution {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if(head == null || n < 1){ 
        	return head;
		}
        
		ListNode endptr = head;
		ListNode removeptr = head;
		ListNode preremoveptr = null;
		int step_count = n;
		while(endptr != null){
        	if(step_count > 0){
        		endptr = endptr.next;
        		step_count--;
        	}else{
        		endptr = endptr.next;
        		preremoveptr = removeptr;
        		removeptr = removeptr.next;
        	}
        }
        
		if(preremoveptr != null){
        	preremoveptr.next = removeptr.next;
        	return head;
        }else{
        	head = removeptr.next;
			return head;  	
        }
    }
}
