package com.zhang.cal.operator;

import com.zhang.cal.CalculatorStack;
import com.zhang.cal.InsucientParameterException;

public interface Operator {
	
	static final String ADD_FLAG = "+";
	
	static final String SUBSTRACT_FLAG = "-";
	
	static final String MULTIPLY_FLAG = "*";
	
	static final String DEVIDE_FLAG = "/";
	
	static final String SQRT_FLAG = "sqrt";
	
	static final String UNDO_FLAG = "undo";
	
	static final String CLEAR_FLAG = "clear";
	
	/**
	 * the flag of this operator in expression
	 **/
	String flag();
	
	/**
	 * the number of operand for this operator
	 * 
	 * 1 : Unary operator
	 * 2 : binary operator
	 * 3 : ternary operator
	 * n : n-ary operator
	 * Integer.MAX_VALUE : unlimited number of operand
	 * */
	int tuple();

	void execute(CalculatorStack stack) throws InsucientParameterException, Exception;
}