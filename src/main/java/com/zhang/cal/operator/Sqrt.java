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
	public int tuple() {
		return 1;
	}

	@Override
	protected void doExecute(final CalculatorStack stack, final BigDecimal[] operands) throws Exception {
		
		final BigDecimal p = operands[0];
		if(p.signum() == -1) {
			throw new Exception("cannot sqrt a negative number");
		}
		final BigDecimal r = BigDecimalMath.sqrt(p, stack.mathContext());
		stack.stack().push(r);
	}
}
