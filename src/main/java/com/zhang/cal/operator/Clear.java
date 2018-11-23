package com.zhang.cal.operator;

import java.math.BigDecimal;

import com.zhang.cal.CalculatorStack;

public class Clear extends AbstractOperator {

	@Override
	public String flag() {
		return Operator.CLEAR_FLAG;
	}

	@Override
	public int tuple() {
		return Integer.MAX_VALUE;
	}
	
	@Override
	protected void doExecute(final CalculatorStack stack, final BigDecimal[] operands)  throws Exception {
		stack.stack().clear();
	}
}
