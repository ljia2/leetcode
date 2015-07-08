package com.leetcode.ljia2.solution002;

import com.leetcode.ljia2.ListNode;

/** You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
**/
public class Solution {
	public ListNode addTwoNumbers(ListNode L1, ListNode L2){
		if(L1 != null && L2 != null){
			int sum = L1.val + L2.val;
			if(sum > 9){
				ListNode result = new ListNode(sum - 10);
				result.next = addTwoNumbersWithCarry(L1.next, L2.next);
				return result;
			}else{
				ListNode result = new ListNode(sum);
				result.next = addTwoNumbers(L1.next, L2.next);
				return result;
			}
		}else if(L1 != null){
			ListNode result = new ListNode(L1.val);
			result.next = addTwoNumbers(L1.next, null);
			return result;
		}else if(L2 != null){
			ListNode result = new ListNode(L2.val);
			result.next = addTwoNumbers(null, L2.next);
			return result;
		}else{
			return null;
		}
	}
	
	public ListNode addTwoNumbersWithCarry(ListNode L1, ListNode L2){
		if(L1 != null && L2 != null){
			int sum = L1.val + L2.val + 1;
			if(sum > 9){
				ListNode result = new ListNode(sum - 10);
				result.next = addTwoNumbersWithCarry(L1.next, L2.next);
				return result;
			}else{
				ListNode result = new ListNode(sum);
				result.next = addTwoNumbers(L1.next, L2.next);
				return result;
			}
		}else if(L1 != null){
			int sum = L1.val + 1;
			if(sum > 9){
				ListNode result = new ListNode(sum - 10);
				result.next = addTwoNumbersWithCarry(L1.next, null);
				return result;
			}else{
				ListNode result = new ListNode(sum);
				result.next = addTwoNumbers(L1.next, null);
				return result;
			}
		}else if(L2 != null){
			int sum = L2.val + 1;
			if(sum > 9){
				ListNode result = new ListNode(sum - 10);
				result.next = addTwoNumbersWithCarry(null, L2.next);
				return result;
			}else{
				ListNode result = new ListNode(sum);
				result.next = addTwoNumbers(null, L2.next);
				return result;
			}
		}else{
			ListNode result = new ListNode(1);
			result.next = null;
			return result;
		}
	}
}
