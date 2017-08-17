package com.synopsys.basiccalculator;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import org.apache.log4j.Logger;

import com.synopsys.basiccalculator.exception.InvalidExpressionException;

/**
 * Class will evaluate the given expression 
 * @author vinaycn
 *
 */
public class BasicCalculator {

	
	
	//private Set<String> operands = new HashSet<>();
	
	public BasicCalculator() {
		
	}
	
	
	
	public int solveExpression(String expresssion){
		if(validateParenthesis(expresssion)){
			
		}else{
			throw new InvalidExpressionException("Expression not well formed")
		}
	}
	
	
	private int solve(String expression){
		
	}
	
	/**
	 * This method will check the given expression is valid or not 
	 * @param given expression
	 * @return true if expression is well formed else false 
	 */
	private  boolean validateParenthesis(String exp){
		char[] expChars = exp.toCharArray();
		Stack<Character> parenthesis = new Stack<>();
		for(int i = 0; i < expChars.length; i++){
			if(expChars[i] == '('){
				parenthesis.push('(');
			}else if(expChars[i] == ')'){
				if(parenthesis.size() < 1) return false;
				parenthesis.pop();
			}
		}
		
		return parenthesis.isEmpty();
	}
}
