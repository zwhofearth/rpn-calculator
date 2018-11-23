package com.zhang.cal.operator;

import java.math.BigDecimal;

import com.zhang.cal.CalculatorStack;
import com.zhang.cal.InsucientParameterException;

public abstract class AbstractOperator implements Operator {

	@Override
	public void execute(final CalculatorStack stack) throws InsucientParameterException, Exception {
		
		int tuple = tuple();
		if(tuple <= 0) {
			return;
		}
		
		if(tuple == Integer.MAX_VALUE) {
			tuple = stack.stack().size();
		} else if(tuple > stack.stack().size()) {
			throw new InsucientParameterException(tuple, stack.stack().size());
		}
		
		BigDecimal[] operands = new BigDecimal[tuple];
		for(int i = tuple - 1; i >= 0; i--) {
			final BigDecimal p = stack.stack().pop();
			operands[i] = p;
		}
		
		doExecute(stack, operands);
	}

	protected abstract void doExecute(final CalculatorStack stack, final BigDecimal[] operands)  throws Exception;
}