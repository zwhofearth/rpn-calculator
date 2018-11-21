package com.zhang.cal.operator;

import java.math.BigDecimal;

import com.zhang.cal.CalculatorStack;

public class Add extends AbstractOperator {

	@Override
	public String flag() {
		return Operator.ADD_FLAG;
	}

	@Override
	protected void doExecute(CalculatorStack stack) throws Exception {

		final BigDecimal p1 = stack.pop();
		final BigDecimal p2 = stack.pop();
		final BigDecimal r = p2.add(p1, stack.mathContext());
		stack.push(r);
	}

}
