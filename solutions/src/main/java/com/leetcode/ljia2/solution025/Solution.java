package com.leetcode.ljia2.solution025;

import com.leetcode.ljia2.ListNode;
/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list. 
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * You may not alter the values in the nodes, only nodes itself may be changed. 
 * Only constant memory is allowed. For example, Given this linked list: 1->2->3->4->5
 * For k = 2, you should return: 2->1->4->3->5
 * For k = 3, you should return: 3->2->1->4->5
 * **/
public class Solution {
	public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 1){
        	return head;
        }
        
        // run the runner to the node where all previous nodes should be reversed
        ListNode runner = head;
        int steps = k;
        while(runner != null && steps > 0){
        	runner = runner.next;
        	steps -= 1;
        }
        
        if(steps > 0){
        	// there is no k nodes from head to tail
        	return head;
        }else{
        	// reverse the K nodes
        	ListNode headrunner = head.next;
        	head.next =  reverseKGroup(runner, k);
        	while(headrunner != null && !headrunner.equals(runner)){
    			ListNode tmp = headrunner.next;
    			headrunner.next = head;
    			head = headrunner;
    			headrunner = tmp;
    		}
    		return head;
        }
    }
}
