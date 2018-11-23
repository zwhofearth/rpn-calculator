package com.zhang.cal;

public class InsucientParameterException extends Exception {

	private static final long serialVersionUID = 6781510681082586480L;

	private int required;
	private int provided;
	
	public InsucientParameterException(int required, int provided) {
		this.required = required;
		this.provided = provided;
	}
	
	public int required() {
		return this.required;
	}
	
	public int provided() {
		return this.provided;
	}
}
