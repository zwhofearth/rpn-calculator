package com.zhang.cal.operator;

import java.math.BigDecimal;

import com.zhang.cal.CalculatorStack;

public class Divide extends AbstractOperator {

	@Override
	public String flag() {
		return Operator.DEVIDE_FLAG;
	}

	@Override
	public void doExecute(CalculatorStack stack) throws Exception {
		final BigDecimal p1 = stack.pop();
		final BigDecimal p2 = stack.pop();
		final BigDecimal r = p2.divide(p1, stack.mathContext());
		stack.push(r);
	}

}
