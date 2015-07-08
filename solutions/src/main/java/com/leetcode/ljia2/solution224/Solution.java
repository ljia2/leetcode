package com.leetcode.ljia2.solution224;

/***
 * Implement a basic calculator to evaluate a simple expression string. The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .
 * You may assume that the given expression is always valid.
 * Some examples:
 * "1 + 1" = 2
 * " 2-1 + 2 " = 3
 * "(1+(4+5+2)-3)+(6+8)" = 23
 * */
public class Solution {
	public int calculate(String s){
		s = s.trim().replaceAll(" ", "");
		char[] c = s.toCharArray();
		// mimic stacks by array
		int[] numberstack = new int[c.length];
		char[] operatorstack = new char[c.length];
		// initialize empty stacks with numberptr = -1 and operatorptr = -1
		int numberptr = -1;
		int operatorptr = -1;
		
		for(int index = 0; index < c.length; index++){
			
			// c is digital
			if(c[index] >= '0' && c[index] <= '9'){
				// push a new char => int into stack, move the numberptr forward and store the new char(int)
				if(index > 0){
					if(c[index-1] >= '0' && c[index-1] <= '9'){
						// need to multiple digit number
						numberstack[numberptr] = 10*numberstack[numberptr] + c[index] - '0';
					}else{
						numberptr += 1;
						numberstack[numberptr] = c[index] - '0';
					}
				}else{
					numberptr += 1;
					numberstack[numberptr] = c[index] - '0';
				}
			}else if(c[index] == '('){
				// push a new operator char into stack, move the operatorptr forward first and store the new operator
				operatorptr += 1;
				operatorstack[operatorptr] = c[index];
			}else if(c[index] == '+' || c[index] == '-'){
				// peek the last operator, in case empty stack
				// if not left parethesis, must be either '+' or '-'
				while(operatorptr > -1 && operatorstack[operatorptr] != '('){
					// fetch the operator and two numbers 
					char operator = operatorstack[operatorptr];
					operatorptr -= 1;
					
					int b = numberstack[numberptr];
					numberptr -= 1;
					
					int a = numberstack[numberptr];
					numberptr -= 1;
					
					if(operator == '+'){
						// push the result into stack: move the numberptr first and store the result
						numberptr += 1;
						numberstack[numberptr] = a + b;
					}else if(operator == '-'){
						// push the result into stack: move the numberptr first and store the result
						numberptr += 1;
						numberstack[numberptr] = a - b;
					}		
				}
				
				operatorptr += 1;
				operatorstack[operatorptr] = c[index];
				
			}else if(c[index] == ')'){
				// peek the top element in the operator stack, in case empty stack
				while(operatorptr > -1 && operatorstack[operatorptr] != '('){
					// fetch the operator and two numbers 
					char operator = operatorstack[operatorptr];
					operatorptr -= 1;
					
					int b = numberstack[numberptr];
					numberptr -= 1;
					
					int a = numberstack[numberptr];
					numberptr -= 1;
					
					if(operator == '+'){
						// push the result into stack: move the numberptr first and store the result
						numberptr += 1;
						numberstack[numberptr] = a + b;
						
					}else if(operator == '-'){
						// push the result into stack: move the numberptr first and store the result
						numberptr += 1;
						numberstack[numberptr] = a - b;
					}				
				}
				// pop '(': 
				operatorptr -= 1;
			}
		}
		
		while(operatorptr > -1){
			char operator = operatorstack[operatorptr];
			operatorptr -= 1;
			
			int b = numberstack[numberptr];
			numberptr -= 1;
			
			int a = numberstack[numberptr];
			numberptr -= 1;
			
			if(operator == '+'){
				// push the result into stack: move the numberptr first and store the result
				numberptr += 1;
				numberstack[numberptr] = a + b;
				
			}else if(operator == '-'){
				// push the result into stack: move the numberptr first and store the result
				numberptr += 1;
				numberstack[numberptr] = a - b;
			}				
		}
		return numberstack[0];
	}

	/**
	 * Implement a complex calculator to evaluate a simple expression string. 
	 * The expression string may contain open ( and closing parentheses ), the plus + , minus sign -, multiple * and divide /, non-negative integers and empty spaces .
	 * You may assume that the given expression is always valid.
	 **/
	
	
}
