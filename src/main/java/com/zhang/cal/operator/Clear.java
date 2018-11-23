package com.zhang.cal.operator;

import com.zhang.cal.CalculatorStack;

public class Clear extends AbstractOperator {

	@Override
	public String flag() {
		return Operator.CLEAR_FLAG;
	}

	@Override
	protected void doExecute(CalculatorStack stack) throws Exception {
		stack.stack().clear();
	}
}
