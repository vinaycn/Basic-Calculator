package com.synopsys.basiccalculator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import org.apache.log4j.Logger;

import com.synopsys.basiccalculator.exception.InvalidExpressionException;

/**
 * Class will evaluate the given expression
 * 
 * @author vinaycn
 *
 */
public class BasicCalculator {

	private static final Logger logger = Logger.getLogger(BasicCalculator.class);

	/**
	 * Will solve the given expression and return the result. Suitable exception
	 * will be thrown if there is an error
	 * 
	 * @param expresssion
	 * @return result of the computed expression
	 * @throws InvalidExpressionException
	 * @throws NumberFormatException
	 * @throws ArithmeticException
	 */
	public int solveExpression(String expresssion)
			throws InvalidExpressionException, NumberFormatException, ArithmeticException {

		if (!validateParenthesis(expresssion))
		{
			logger.info("Invalid Expression thrown");
			throw new InvalidExpressionException("Expression not well formed");
		}
			

		return calculate(expresssion, new HashMap<String, Integer>());
	}

	/**
	 * function will recursively evaluate the expression and returns the result.
	 * 
	 * @param expression
	 *            : given expression to be parsed
	 * @param variablesMap
	 *            : hashMap to store the variable
	 * @return
	 * @throws NumberFormatException
	 * @throws ArithmeticException
	 * @throws InvalidExpressionException
	 */
	private int calculate(String expression, Map<String, Integer> variablesMap)
			throws NumberFormatException, ArithmeticException, InvalidExpressionException {

		List<String> parsedList = new ArrayList<>();
		int startPos = expression.indexOf("(");

		if (startPos < 0) {
			if (variablesMap.get(expression) != null)
				return variablesMap.get(expression);
			return Integer.parseInt(expression);
		}

		// Add the operator to the list
		parsedList.add(expression.substring(0, startPos));
		int parenthesis = 0;

		for (int i = startPos; i < expression.length(); i++) {

			if (expression.charAt(i) == '(')
				parenthesis++;

			if (expression.charAt(i) == ')')
				parenthesis--;

			if (expression.charAt(i) == ',' && parenthesis == 1 || parenthesis == 0) {
				parsedList.add(expression.substring(startPos + 1, i));
				startPos = i;
			}
		}

		if (parsedList.get(0).equalsIgnoreCase("add")) {
			if (parsedList.size() != 3) {
				throw new InvalidExpressionException("Exception while parsing expression");
			}
			return calculate(parsedList.get(1), variablesMap) + calculate(parsedList.get(2), variablesMap);
		} else if (parsedList.get(0).equalsIgnoreCase("mult")) {
			if (parsedList.size() != 3) {
				throw new InvalidExpressionException("Exception while parsing expression");
			}
			return calculate(parsedList.get(1), variablesMap) * calculate(parsedList.get(2), variablesMap);
		} else if (parsedList.get(0).equalsIgnoreCase("sub")) {
			if (parsedList.size() != 3) {
				throw new InvalidExpressionException("Exception while parsing expression");
			}
			return calculate(parsedList.get(1), variablesMap) - calculate(parsedList.get(2), variablesMap);
		} else if (parsedList.get(0).equalsIgnoreCase("div")) {
			if (parsedList.size() != 3) {
				throw new InvalidExpressionException("Exception while parsing expression");
			}
			return calculate(parsedList.get(1), variablesMap) / calculate(parsedList.get(2), variablesMap);
		} else if (parsedList.get(0).equalsIgnoreCase("let")) {
			if (parsedList.size() != 4) {
				throw new InvalidExpressionException("Exception while parsing expression");
			}
			String variableName = parsedList.get(1);
			Integer oldValue = variablesMap.get(variableName);
			variablesMap.put(variableName, calculate(parsedList.get(2), variablesMap));

			int result = calculate(parsedList.get(3), variablesMap);
			variablesMap.put(variableName, oldValue);

			return result;
		} else {
			throw new InvalidExpressionException("Exception While parsing expression");
		}

	}

	/**
	 * This method will check the given expression is valid or not
	 * 
	 * @param given
	 *            expression
	 * @return true if expression is well formed else false
	 */
	private boolean validateParenthesis(String exp) {

		logger.info("parsing the expression to check its well formed or not");
		char[] expChars = exp.toCharArray();
		Stack<Character> parenthesis = new Stack<>();
		for (int i = 0; i < expChars.length; i++) {
			if (expChars[i] == '(') {
				parenthesis.push('(');
			} else if (expChars[i] == ')') {
				if (parenthesis.size() < 1) {
					logger.error("given expression is not well formed");
					return false;
				}

				parenthesis.pop();
			}
		}

		return parenthesis.isEmpty();
	}
}
