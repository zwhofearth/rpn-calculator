package com.zhang.cal.operator;

import java.math.BigDecimal;

import com.zhang.cal.CalculatorStack;

import ch.obermuhlner.math.big.BigDecimalMath;

public class Sqrt extends AbstractOperator {
	
	@Override
	public String flag() {
		return Operator.SQRT_FLAG;
	}

	@Override
	protected void doExecute(CalculatorStack stack) throws Exception {
		final BigDecimal p = stack.stack().pop();

		BigDecimal r = BigDecimalMath.sqrt(p, stack.mathContext());
		stack.stack().push(r);
	}
}
