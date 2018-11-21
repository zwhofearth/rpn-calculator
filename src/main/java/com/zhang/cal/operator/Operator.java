package com.zhang.cal.operator;

import com.zhang.cal.CalculatorStack;

public interface Operator {
	
	static final String ADD_FLAG = "+";
	
	static final String SUBSTRACT_FLAG = "-";
	
	static final String MULTIPLY_FLAG = "*";
	
	static final String DEVIDE_FLAG = "/";
	
	static final String SQRT_FLAG = "+";
	
	static final String UNDO_FLAG = "+";
	
	static final String CLEAR_FLAG = "+";
	
	String flag();
	
	void execute(CalculatorStack stack);
}