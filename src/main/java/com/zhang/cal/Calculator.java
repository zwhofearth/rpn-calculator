package com.zhang.cal;

import java.io.PrintStream;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.zhang.cal.operator.Operator;

final public class Calculator {
	
	private final CalculatorStack calculatorStack = new CalculatorStack();
	
	private final Map<String, Operator> operatorMap = new HashMap<>();
	
	private int scale = 10;
	
	private RoundingMode roundingMode = RoundingMode.HALF_UP;
	
	private DecimalFormat decimalFormat = new DecimalFormat("#.##########");
	
	public Calculator() {
	}

	public Map<String, Operator> addOperator(final Operator operator) {
		
		if(operator != null && ! operatorMap.containsKey(operator.flag())) {
			operatorMap.put(operator.flag(), operator);
		}
		
		return operatorMap;
	}

	public int getScale() {
		return scale;
	}

	public void setScale(int scale) {
		this.scale = scale;
	}

	public RoundingMode getRoundingMode() {
		if(roundingMode == null) {
			roundingMode = RoundingMode.HALF_UP;
		}
		return roundingMode;
	}

	public void setRoundingMode(RoundingMode roundingMode) {
		if(roundingMode != null) {
			this.roundingMode = roundingMode;
		}
	}

	public MathContext getMathContext() {
		return calculatorStack.mathContext();
	}

	public void setMathContext(final MathContext mathContext) {
		calculatorStack.mathContext(mathContext);
	}

	public void process(final String line, final PrintStream out) {

		//int originalPos = 0; //calculatorStack.stack().size();
		int originalPos = 1;
		final Scanner scanner = new Scanner(line);
		while (scanner.hasNext()) {
			
			final String token = scanner.next();

			if(operatorMap.containsKey(token)) {
				
				Operator operator = operatorMap.get(token);
				try {
					operator.execute(calculatorStack);
				} catch (InsucientParameterException e) {
					String errorMsg = String.format("operator %s (position: %d): insucient parameters", token, originalPos);
					out.println(errorMsg);
					break;
				} catch (Exception e) {
					String errorMsg = String.format("operator %s (position: %d): operation error(%s)", token, originalPos, e.getMessage());
					out.println(errorMsg);
					break;
				}
				
				originalPos += (token.length() + 1);
				
				continue;
			}
			
			try {
				BigDecimal operand = new BigDecimal(token, calculatorStack.mathContext());
				calculatorStack.stack().push(operand);
			} catch (Exception e) {
				String errorMsg = String.format("unsupported operator or is not an correct operand (position: %d) : %s", originalPos, token);
				out.println(errorMsg);
				break;
			}
			
			originalPos += (token.length() + 1);
		}
		
		scanner.close();
		print(out);
	}
	
	private void print(final PrintStream out) {

		out.print("stack :");
		for(int i = 0; i < calculatorStack.stack().size(); i++) {
			BigDecimal operand = calculatorStack.stack().get(i);
			operand = operand.setScale(scale, this.getRoundingMode());
			out.print(" ");
			out.print(decimalFormat.format(operand));
		}
		out.println();
	}
}
