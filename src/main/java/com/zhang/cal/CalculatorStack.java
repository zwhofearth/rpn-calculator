package com.zhang.cal;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Stack;

public class CalculatorStack implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3484515783735007077L;

	private final Stack<BigDecimal> stack;
	
	private MathContext mathContext;

	public CalculatorStack() {
		this.stack = new Stack<BigDecimal>();
		this.mathContext = new MathContext(15, RoundingMode.HALF_UP);
	}

	public boolean isEmpty() {
		return this.stack.isEmpty();
	}

	public void push(final String number) {
		final BigDecimal newnum = new BigDecimal(number);
		this.stack.push(newnum);
	}
	
	public void push(final BigDecimal number) {
		this.stack.push(number);
	}

	public BigDecimal pop() throws Exception {
		
		if (!this.stack.isEmpty()) {
			return this.stack.pop();
		}
		
		throw new Exception();
	}
	
	public void clear() throws Exception {
		this.stack.clear();
	}
	
    public int size() {
        return this.stack.size();
    }
    
    public MathContext mathContext() {
    	return mathContext;
    }
}