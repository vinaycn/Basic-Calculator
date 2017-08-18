package com.synopsys.basiccalculator;

import com.synopsys.basiccalculator.exception.InvalidExpressionException;

public class BasicCalculatorMain {

	public static void main(String[] args){
		BasicCalculator basicCalculator = new BasicCalculator();
		try {
			basicCalculator.solveExpression(args[0]);
		} catch (NumberFormatException | ArithmeticException | InvalidExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
