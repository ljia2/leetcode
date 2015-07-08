package com.leetcode.ljia2.solution003;

import java.util.Arrays;
import java.util.HashMap;
/**
 * Given a string, find the length of the longest substring without repeating characters. 
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. 
 * For "bbbbb" the longest substring is "b", with the length of 1.
 * 
 * Trick I: give "abcdecghi", we set start and end two pointers.
 * First we get "abcde" with max_length = 5 start = 0 and end = 5;
 * when end moves to 6, we encounter 'c' matches the first c. 
 * Then we can set start = index next to the first matched c and the end keeps moving from 6 (to 7)
 * we need to update the index of c from 2 to 6.
 * 
 * Trick II: use int[] to record the indexes of chars
 **/
public class Solution {
	public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){ return 0; }
        char[] charlist = s.toCharArray();
        // initialize the indexTable with -1s. 
        int[] indexTable = new int[256];
        Arrays.fill(indexTable, -1);
        
        int max_length = 1;
        int start = 0, end = 1;
        indexTable[charlist[start]] = 0;
    	while(end < charlist.length){
    		/* Trick III: when indexTable[charlist[end]] > -1
    		 * a) charlist[end] was encountered before
    		 * b) however, if charlist[end] < start, charlist[end] is not repeated within substr[start:end]
    		 * c) if charlist[end] >= start, then charlist[end] is repeated within charlist[start:end]
    		 * 									  c.1) update the max_length
    		 * 									  c.2) reset start as the index next to the matched char
    		 * 									  c.3) record the index of charlist[end]
    		 * 									  c.3) keep moving end
    		 *	d) else:
    		 *		d.1) record the index of charlist[end]
    		 *		d.2) keep moving end
    		*/
     		if(indexTable[charlist[end]] >= start){
    			max_length = Math.max(max_length, end - start);
    			start = indexTable[charlist[end]] + 1;
    		}
    		indexTable[charlist[end]] = end;
    		end += 1;
    	}
    	// when exit the loop, we need to compare the last substr with the max_length
    	return Math.max(max_length,  charlist.length - start);
    }
}
