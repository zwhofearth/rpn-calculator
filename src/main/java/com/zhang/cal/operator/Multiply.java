package com.zhang.cal.operator;

import java.math.BigDecimal;

import com.zhang.cal.CalculatorStack;

public class Multiply extends AbstractOperator {

	@Override
	public String flag() {
		return Operator.MULTIPLY_FLAG;
	}

	@Override
	protected void doExecute(CalculatorStack stack) throws Exception {
		final BigDecimal p1 = stack.pop();
		final BigDecimal p2 = stack.pop();
		final BigDecimal r = p2.multiply(p1, stack.mathContext());
		stack.push(r);
	}
}
