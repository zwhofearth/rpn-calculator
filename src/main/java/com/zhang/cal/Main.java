package com.zhang.cal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.List;

import com.zhang.cal.operator.Add;
import com.zhang.cal.operator.Clear;
import com.zhang.cal.operator.Divide;
import com.zhang.cal.operator.Multiply;
import com.zhang.cal.operator.Operator;
import com.zhang.cal.operator.Sqrt;
import com.zhang.cal.operator.Subtract;
import com.zhang.cal.operator.Undo;

public class Main {

	public static void main(String[] args) {
		
		List<Operator> operatorList = new LinkedList<>();
		operatorList.add(new Add());
		operatorList.add(new Subtract());
		operatorList.add(new Multiply());
		operatorList.add(new Divide());
		operatorList.add(new Sqrt());
		operatorList.add(new Clear());
		operatorList.add(new Undo());
		
		CalculatorBuilder builder = new CalculatorBuilder()
				.scale(10)
				.roundingMode(RoundingMode.FLOOR)
				.mathContext(new MathContext(30, RoundingMode.FLOOR))
				.decimalFormat(new DecimalFormat("#.##########"))
				.operators(operatorList);
		
		Calculator calculator = null;
		try {
			calculator = builder.build();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return;
		} finally {
			operatorList = null;
			builder = null;
		}
		
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			
			do {
				String line = br.readLine();
				line = line.trim();
				if (line.startsWith("quit")) {
					System.out.println("quited");
					break;
				}
				
				calculator.process(line, System.out);
			} while (true);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
