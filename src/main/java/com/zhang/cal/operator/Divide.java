package com.zhang.cal.operator;

import java.math.BigDecimal;

import com.zhang.cal.CalculatorStack;

public class Divide extends AbstractOperator {

	@Override
	public String flag() {
		return Operator.DEVIDE_FLAG;
	}

	@Override
	public int tuple() {
		return 2;
	}
	
	@Override
	protected void doExecute(final CalculatorStack stack, final BigDecimal[] operands)  throws Exception {

		final BigDecimal p1 = operands[0];
		final BigDecimal p2 = operands[1];
		final BigDecimal r = p1.divide(p2, stack.mathContext());
		stack.stack().push(r);
	}
}
