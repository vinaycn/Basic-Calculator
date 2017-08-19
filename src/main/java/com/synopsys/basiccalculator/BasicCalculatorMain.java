package com.synopsys.basiccalculator;

import org.apache.log4j.Logger;

import com.synopsys.basiccalculator.exception.InvalidExpressionException;

public class BasicCalculatorMain {

	private static final Logger logger = Logger.getLogger(BasicCalculatorMain.class);

	public static void main(String[] args) {
		BasicCalculator basicCalculator = new BasicCalculator();
		try {
			logger.info("Received input evaluating the expression");
			System.out.println(basicCalculator.solveExpression(args[0]));
		} catch (InvalidExpressionException e) {
			System.out.println(e.getMessage());
			logger.error(e.getMessage());
		} catch (NumberFormatException e) {
			System.out.println("Error while parsing string to number " +e.getMessage());
			logger.error(e.getMessage());
		} catch (ArithmeticException e) {
			System.out.println("Error while calculating " +e.getMessage());
			logger.error(e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected Exception occured " +e.getMessage());
			logger.error(e.getMessage());
		}

	}
}
