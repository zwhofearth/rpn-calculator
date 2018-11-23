package com.zhang.cal;

import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.List;

import com.zhang.cal.operator.Operator;

public class CalculatorBuilder {
	
	private Integer scale;
	
	private RoundingMode roundingMode;
	
	private MathContext mathContext;
	
	private DecimalFormat decimalFormat;
	
	private List<Operator> operatorList = new LinkedList<>();
	
	
	public Calculator build() throws Exception {
		
		Calculator calculator = new Calculator();
		
		if(scale == null || scale <= 0) {
			calculator.setScale(10);
		} else {
			calculator.setScale(scale);
		}
		
		if(roundingMode == null) {
			calculator.setRoundingMode(RoundingMode.HALF_UP);;
		} else {
			calculator.setRoundingMode(roundingMode);;
		}
		
		if(mathContext == null) {
			calculator.setMathContext(new MathContext(15, RoundingMode.HALF_UP));
		} else {
			calculator.setMathContext(mathContext);
		}
		
		if(decimalFormat == null) {
			decimalFormat = new DecimalFormat("#.##########");
		}
		
		if(operatorList == null || operatorList.isEmpty()) {
			throw new Exception("at least provide an operator");
		}
		
		for(Operator operator : operatorList) {
			calculator.addOperator(operator);
		}
		
		return calculator;
	}
	
	public CalculatorBuilder scale(Integer scale) {
		this.scale = scale;
		return this;
	}
	
	public CalculatorBuilder roundingMode(RoundingMode roundingMode) {
		this.roundingMode = roundingMode;
		return this;
	}
	
	public CalculatorBuilder mathContext(MathContext mathContext) {
		this.mathContext = mathContext;
		return this;
	}
	
	public CalculatorBuilder decimalFormat(DecimalFormat decimalFormat) {
		this.decimalFormat = decimalFormat;
		return this;
	}
	
	public CalculatorBuilder operator(final Operator operator) {
		
		if(! operatorList.contains(operator)) {
			operatorList.add(operator);
		}
		
		return this;
	}
	
	public CalculatorBuilder removeOperator(final Operator operator) {
		
		if(operatorList.contains(operator)) {
			operatorList.remove(operator);
		}
		
		return this;
	}
	
	public CalculatorBuilder operators(final List<Operator> operatorList) {
		
		for(Operator operator : operatorList) {
			this.operator(operator);
		}

		return this;
	}
	
	public CalculatorBuilder removeOperators(final List<Operator> operatorList) {
		
		this.operatorList.removeAll(operatorList);

		return this;
	}

	public Integer scale() {
		return this.scale;
	}
	
	public RoundingMode roundingMode() {
		return this.roundingMode;
	}
	
	public MathContext mathContext() {
		return this.mathContext;
	}
	
	public DecimalFormat decimalFormat() {
		return this.decimalFormat;
	}
	
	public List<Operator> operatorList() {
		
		List<Operator> operatorList = new LinkedList<>();
		operatorList.addAll(this.operatorList);
		return this.operatorList;
	}
}
