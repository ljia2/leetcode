package com.leetcode.ljia2.solution008;

/**
 * Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

Update (2015-02-10):
The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button  to reset your code definition.

spoilers alert... click to show requirements for atoi.

Requirements for atoi:
The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 * */


public class Solution {
	public int myAtoi(String str) {
		if(str == null || str.trim().equalsIgnoreCase("")){ return 0; }
		char[] clist = str.trim().toCharArray();
		int abs_int = 0;
		boolean negative = false;
		boolean digithit = false;
		for(int cindex = 0; cindex < clist.length; cindex++){
			if(cindex == 0){
				if(clist[0] == '-'){
					negative = true;
				}else if(clist[0] == '+'){
					continue;
				}else{
					int digit = clist[cindex] - '0';
					if(digit >= 0 && digit <= 9){
						if(!digithit)
							digithit = true;
						
						if(negative){
							if((Integer.MIN_VALUE + digit)/10 > 0 - abs_int){
								//throw new RuntimeException("UnderFlow" + str);
								return Integer.MIN_VALUE;
							}else{
								abs_int = 10*abs_int + digit;
							}
						}else{
							if((Integer.MAX_VALUE - digit)/10 < abs_int){
								//throw new RuntimeException("OverFlow" + str);
								return Integer.MAX_VALUE;
							}else{
								abs_int = 10*abs_int + digit;
							}
						}
					}else{
						//throw new RuntimeException("Incorrect Format" + str);
						return 0;
					}
				}
			}else{
				int digit = clist[cindex] - '0';
				if(digit >= 0 && digit <= 9){
					if(!digithit)
						digithit = true;
					
					if(negative){
						if((Integer.MIN_VALUE + digit)/10 > 0 - abs_int){
							//throw new RuntimeException("UnderFlow" + str);
							return Integer.MIN_VALUE;
						}else{
							abs_int = 10*abs_int + digit;
						}
					}else{
						if((Integer.MAX_VALUE - digit)/10 < abs_int){
							//throw new RuntimeException("OverFlow" + str);
							return Integer.MAX_VALUE;
						}else{
							abs_int = 10*abs_int + digit;
						}
					}
				}else if(digithit){
					break;
				}else{
					return 0;
				}
			}	
		}
		return negative? 0 - abs_int : abs_int;
    }
}
