package com.zhang.cal.operator;

import java.util.EmptyStackException;

import com.zhang.cal.CalculatorStack;

public abstract class AbstractOperator implements Operator {

	@Override
	public void execute(final CalculatorStack stack) {

		if(stack == null) {
			System.out.println("operator stack is null");
		}
		
		try {
			doExecute(stack);
			
		} catch(EmptyStackException e) {
			System.err.println("operator * (position: 15): insucient parameters");
			
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}

	protected abstract void doExecute(final CalculatorStack stack)  throws Exception;
}