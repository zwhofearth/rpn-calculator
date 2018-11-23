package com.zhang.cal.operator;

import java.math.BigDecimal;

import com.zhang.cal.CalculatorStack;

public class Undo extends AbstractOperator {

	@Override
	public String flag() {
		return Operator.UNDO_FLAG;
	}
	
	@Override
	public int tuple() {
		return 1;
	}

	@Override
	protected void doExecute(final CalculatorStack stack, final BigDecimal[] operands) throws Exception {
		return;
	}
}
