package com.leetcode.ljia2.solution044;
/**
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * Some examples:
 * isMatch("aa","a") ¡ú false
 * isMatch("aa","aa") ¡ú true
 * isMatch("aaa","aa") ¡ú false
 * isMatch("aa", "*") ¡ú true
 * isMatch("aa", "a*") ¡ú true
 * isMatch("ab", "?*") ¡ú true
 * isMatch("aab", "c*a*b") ¡ú false
 * 
 * 
 * **/
public class Solution {
	public boolean isMatch(String s, String p) {
		if(s == null){
			if(p==null){ 
				return true;
			}else{
				return false;
			}
		}else if(p == null){
			return false;
		}
		
		if (p.equals("*")) return true;
		
		p = p.replaceAll("\\*+", "*");
		
		int sptr = 0;
		int pptr = 0;
		while(sptr < s.length() && pptr < p.length()){
			if(s.charAt(sptr) == p.charAt(pptr)){
				sptr++;
				pptr++;
			}else if(p.charAt(pptr) == '?'){
				sptr++;
				pptr++;
			}else if(p.charAt(pptr) == '*'){
				while(sptr < s.length()-1 && pptr < p.length()-1){
					if(isMatch(s.substring(sptr+1), p.substring(pptr+1))){
						return true;
					}else{
						sptr += 1;
					}
				}
				if(pptr == p.length()-1){
					return true;
				}else if(sptr == s.length()-1){
					return false;
				}
			}else{
				return false;
			}
		}
		if(sptr == s.length() && pptr == p.length()){
			return true;
		}
		return false;
    }
}
