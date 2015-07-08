package com.leetcode.ljia2.solution023;

import com.leetcode.ljia2.ListNode;

public class SolutionII {
	public ListNode mergeKLists(ListNode[] lists) {
		if(lists == null || lists.length == 0){
			return null;
		}else if(lists.length == 1){
			return lists[0];
		}else{
			ListNode[] newlists = new ListNode[lists.length-1];
			for(int index = 1; index < lists.length; index++){
				newlists[index-1] = lists[index];
			}
			ListNode preresults = mergeKLists(newlists);
			return mergeTwoSortedLists(lists[0], preresults);
		}
	}
	
	public ListNode mergeTwoSortedLists(ListNode l1, ListNode l2){
		if(l1 == null && l2 == null){
			return null;
		}else if(l1 == null){
			return l2;
		}else if(l2 == null){
			return l1;
		}else{
			ListNode head = null;
			ListNode runner = null;
			while(l1 != null && l2 != null){
				if(l1.val <= l2.val){
					if(runner == null){
						head = l1;
						runner = l1;
					}else{
						runner.next = l1;
						runner = runner.next;
					}
					l1 = l1.next;
				}else{
					if(runner == null){
						head = l2;
						runner = l2;
					}else{
						runner.next = l2;
						runner = runner.next;
					}
					l2 = l2.next;
				}
			}
			if(l1 != null){
				runner.next = l1;
			}else{
				runner.next = l2;
			}
			return head;
		}
	}
}
