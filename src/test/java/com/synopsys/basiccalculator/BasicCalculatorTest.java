package com.synopsys.basiccalculator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.synopsys.basiccalculator.exception.InvalidExpressionException;


public class BasicCalculatorTest {

	private BasicCalculator basicCalculator;

	@Before
	public void initialize() {
		basicCalculator = new BasicCalculator();
	}

	@Test(expected = InvalidExpressionException.class)
	public void givenNotWellFormedExpressionShouldThrowException()
			throws NumberFormatException, ArithmeticException, InvalidExpressionException {
		basicCalculator.solveExpression("add(2,add(2,3)))");
	}

	@Test(expected = NumberFormatException.class)
	public void givenInValidExpressionShouldThrowNumberFormatException()
			throws NumberFormatException, ArithmeticException, InvalidExpressionException {
		basicCalculator.solveExpression("add(a,add(2,3))");
	}

	@Test(expected = ArithmeticException.class)
	public void givenExpressionWithDivisionForZeroThrowArithmeticException()
			throws NumberFormatException, ArithmeticException, InvalidExpressionException {
		basicCalculator.solveExpression("add(1,div(2,0))");
	}

	@Test
	public void givenValidExpressionShouldReturnCorrectResult()
			throws NumberFormatException, ArithmeticException, InvalidExpressionException {
		int result = basicCalculator.solveExpression("mult(add(2,3),add(2,mult(3,4)))");
		Assert.assertEquals(70,result);
	}
	
	
	@Test(expected = InvalidExpressionException.class)
	public void givenInvaliExpressionMoreCommaShouldThrowException()
			throws NumberFormatException, ArithmeticException, InvalidExpressionException {
		int result = basicCalculator.solveExpression("mult(add(2,3),,add(2,mult(3,4)))");
		Assert.assertEquals(70,result);
	}
	
	@Test(expected = ArithmeticException.class)
	public void givenExpressionShouldThrowOverflowException()
			throws NumberFormatException, ArithmeticException, InvalidExpressionException {
		int result = basicCalculator.solveExpression("mult(add(2,3),add(2,mult(222222,4344444)))");
		Assert.assertEquals(70,result);
	}

}
