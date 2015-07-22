package com.leetcode.ljia2.solution061;

import com.leetcode.ljia2.ListNode;

/**
 * Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
 * 
 * ***/

public class Solution {
	 public ListNode rotateRight(ListNode head, int k) {
	      if(head == null || head.next == null) return head;
	      
	      ListNode endrunner = head;
	      int numNodes = 1;
	      while(endrunner.next != null){
	    	  endrunner = endrunner.next;
	    	  numNodes += 1;
	      }	      
	      k = k % numNodes;
	      if(k == 0) return head;
	      
	      endrunner = head;
	      ListNode newend = null;
	      while(endrunner.next != null){
	    	  endrunner = endrunner.next;
	    	  k -= 1;
	    	  if(k == 0){
	    		  newend = head;
	    	  }else if(k < 0){
	    		  newend = newend.next;
	    	  }
	      }
	      
	      endrunner.next = head;
	      head = newend.next;
	      newend.next = null;
	      return head;
	 }
}
