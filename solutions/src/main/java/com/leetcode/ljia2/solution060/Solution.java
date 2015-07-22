package com.leetcode.ljia2.solution060;

import java.util.HashSet;

/**
 * The set [1,2,3,бн,n] contains a total of n! unique permutations.
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 * Note: Given n will be between 1 and 9 inclusive.
 * 
 * 
 * Solution: 
 *   tip: 1) determine digits one by one from high to low.
 *        2) give n and k, factorial = (n-1)! and get k/(n-1)! to determine the first digit and put first digit into isUsed;
 *        3) update k = k % factorial + k % factorial == 0 ? factorial : 0
 *        	 update factorial = (n-2)! to determine the second digit;
 * 
 * 
 * 
 * **/
public class Solution {
	public String getPermutation(int n, int k) {
        String result = "";
        HashSet<Integer> isUsed = new HashSet<Integer>();
        int factorial = 1;
        for(int i = 2; i < n; i++){
        	factorial *= i;
        }
        // handle the first n-1 digits
        for(int i = n - 1; i > 0; i--){
        	// trick : get the ceiling of two int division: (int) Math.ceil((double)k/factorial)
        	result += getDigit(isUsed, n, (int) Math.ceil((double)k/factorial));
        	if(k % factorial == 0){
        		k = factorial; 
        	}else{
        		k = k % factorial;
        	}
        	factorial /= i; 
        }
        
        // handle the last digit
        for(int i = 1; i < n+1; i++){
        	if(!isUsed.contains(i)){
        		result += String.valueOf(i);
        	}
        }
        return result;
        
    }
	
	public String getDigit(HashSet<Integer> isUsed, int n, int hitindex){
		int index = 0;
		for(int i = 1; i < n+1; i++){
			if(isUsed.contains(i)) continue;
			index += 1;
			if(index == hitindex){
				isUsed.add(i);
				return String.valueOf(i);
			}			
		}
		return "";
	}
}
