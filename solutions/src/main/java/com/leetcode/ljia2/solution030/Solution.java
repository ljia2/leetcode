package com.leetcode.ljia2.solution030;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/***
 * You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
 * For example, given: 
 * s:"barfoothefoobarman"
 * words: ["foo", "bar"]
 * You should return the indices: [0,9].
 * 
 * Solution: 
 * 1) Slide widow of windowsize to scan all substrings of size windowsize
 * 2) check each substring weather substring is concatenation of all words in dictionary
 * 3) if so, record the start index of the sliding window;
 * 4) move the sliding window to right one step. 
 * */


public class Solution {
	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> results = new ArrayList<Integer>();
		if(s == null || s.length() == 0 || words == null || words.length == 0){
			return results;
		}
		
		// store a snapshot of the dictinary;
		HashMap<String, Integer> dict = new HashMap<String, Integer>();
		for(String word : words){
			dict.put(word, !dict.containsKey(word)? 1 : dict.get(word) + 1);
		}
		
		int wordsize = words[0].length();
		int window_size = wordsize*words.length;
		HashMap<String, Integer> snapshot = new HashMap<String, Integer>();
		// scan all substring with the length of window_size;
		for(int start = 0; start + window_size < s.length() + 1; start++){
			snapshot.clear();
			int window_start = start;
			// iterates every word of size wordsize
			while(window_start < start + window_size){
				String word = s.substring(window_start, window_start + wordsize);
				if(dict.containsKey(word)){
					snapshot.put(word, snapshot.containsKey(word)? snapshot.get(word)+1 : 1);
					window_start += wordsize;
				}else{
					// there is not such a word in the substring not in the dictionary. Skip this substring
					break;
				}
			}
			// trick: use object equals to determine whether all words in substring is those in dict. 
			if(snapshot.equals(dict)){
				results.add(start);
			}
		}
		
		return results;
	}
}
