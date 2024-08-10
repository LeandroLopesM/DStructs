package com.utils;

public class StackUnderflowError extends VirtualMachineError {
	private static final long serialVersionUID = 4319243482634382468L;

	public StackUnderflowError() {
		super();
	}
	
	public StackUnderflowError(String s) {
		super(s);
	}
}
