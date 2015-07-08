package com.leetcode.ljia2.solution227;
/***
 * Implement a basic calculator to evaluate a simple expression string. The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . 
 * The integer division should truncate toward zero. You may assume that the given expression is always valid.
 * Some examples:
 * "3+2*2" = 7
 * " 3/2 " = 1
 * " 3+5 / 2 " = 5
 * Note: Do not use the eval built-in library function.
 * 
 * */
public class Solution {
	public int calculate(String s) {
		s = s.trim().replaceAll(" ", "");
		char[] c = s.toCharArray();
		char[] optstack = new char[c.length];
		int optptr = -1;
		int[] numstack = new int[c.length];
		int numptr = -1;
		for(int index = 0; index < c.length; index++){
			if(c[index] >= '0' && c[index] <= '9'){
				if(index > 0){
					if(c[index-1] >= '0' && c[index-1] <= '9'){
						numstack[numptr] = 10*numstack[numptr] + c[index] - '0';
					}else{
						numptr += 1;
						numstack[numptr] = c[index] - '0';
					}
				}else{
					numptr += 1;
					numstack[numptr] = c[index] - '0';
				}
			}else if(c[index] == '('){
				optptr += 1;
				optstack[optptr] = c[index];
			}else if(c[index] == '/' || c[index] == '*'){
				// make sure the last operator have the same priority as current operator, then pop 2 numbers and the last operator and make the calculation
				while(optptr > -1 && (optstack[optptr] == '*' || optstack[optptr] == '/')){
					char operator = optstack[optptr];
					optptr -= 1;
					
					int b = numstack[numptr];
					numptr -= 1;
					
					int a = numstack[numptr];
					numptr -= 1;
					
					if(operator == '*'){
						numptr += 1;
						numstack[numptr] = a*b;
					}else if(operator == '/'){
						numptr += 1;
						numstack[numptr] = a/b;
					}
				}
				optptr += 1;
				optstack[optptr] = c[index];
				
			}else if(c[index] == '+' || c[index] == '-'){
				// make sure the last operator have the same or higher priority as current operator
				// since current operator is '+' or '-', all the operators have at least the same priority
				// then pop 2 numbers and the last operator and make the calculation
				while(optptr > -1 && optstack[optptr] != '('){
					char operator = optstack[optptr];
					optptr -= 1;
					
					int b = numstack[numptr];
					numptr -= 1;
					
					int a = numstack[numptr];
					numptr -= 1;
					
					switch (operator) {
						case '+':
							numptr += 1;
							numstack[numptr] = a + b;
							break;
						case '-':
							numptr += 1;
							numstack[numptr] = a - b;
							break;
						case '*':
							numptr += 1;
							numstack[numptr] = a * b;
							break;
						case '/':
							numptr += 1;
							numstack[numptr] = a / b;
							break;
						default:
							break;
					}
				}
				optptr += 1;
				optstack[optptr] = c[index];
			}else if(c[index] == ')'){
				while(optptr > -1 && optstack[optptr] != '('){
					char operator = optstack[optptr];
					optptr -= 1;
					
					int b = numstack[numptr];
					numptr -= 1;
					
					int a = numstack[numptr];
					numptr -= 1;
					
					switch (operator) {
						case '+':
							numptr += 1;
							numstack[numptr] = a + b;
							break;
						case '-':
							numptr += 1;
							numstack[numptr] = a - b;
							break;
						case '*':
							numptr += 1;
							numstack[numptr] = a * b;
							break;
						case '/':
							numptr += 1;
							numstack[numptr] = a / b;
							break;
						default:
							break;
					}
				}
				optptr -= 1;
			}
		}
		
		while(optptr > -1){
			char operator = optstack[optptr];
			optptr -= 1;
			
			int b = numstack[numptr];
			numptr -= 1;
			
			int a = numstack[numptr];
			numptr -= 1;
			
			switch (operator) {
				case '+':
					numptr += 1;
					numstack[numptr] = a + b;
					break;
				case '-':
					numptr += 1;
					numstack[numptr] = a - b;
					break;
				case '*':
					numptr += 1;
					numstack[numptr] = a * b;
					break;
				case '/':
					numptr += 1;
					numstack[numptr] = a / b;
					break;
				default:
					break;
			}
		}
		return numstack[0];
	}
}
