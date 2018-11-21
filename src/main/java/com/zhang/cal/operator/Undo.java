package com.zhang.cal.operator;

import com.zhang.cal.CalculatorStack;

public class Undo extends AbstractOperator {

	@Override
	public String flag() {
		return Operator.UNDO_FLAG;
	}

	@Override
	protected void doExecute(CalculatorStack stack) throws Exception {
		stack.pop();
	}
}
