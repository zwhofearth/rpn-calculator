package com.zhang.cal;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Stack;

public class CalculatorStack implements Serializable {

	private static final long serialVersionUID = 3484515783735007077L;

	private final Stack<BigDecimal> stack;
	
	private MathContext mathContext = new MathContext(30, RoundingMode.HALF_UP);

	public CalculatorStack() {
		this.stack = new Stack<BigDecimal>();
	}
    
    public MathContext mathContext() {
    	if(mathContext == null) {
    		this.mathContext = new MathContext(30, RoundingMode.HALF_UP);
    	}
    	return mathContext;
    }
    
    public void mathContext(MathContext mathContext) {
    	if(mathContext != null) {
    		this.mathContext = mathContext;
    	}
    }

	public Stack<BigDecimal> stack() {
		return stack;
	}
}