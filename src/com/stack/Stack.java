package com.stack;

import com.utils.StackUnderflowError;

public class Stack {
	private Object[] sStruct = null;
	private int MAX = -1;
	private int sPtr = 0;
	
	public Stack( int maxSize ) {
		sStruct = new Object[maxSize];
		MAX = maxSize;		
	}
	
	public void push( Object val ) throws StackOverflowError{
		if( sPtr == MAX ) throw new StackOverflowError("Stack is full");
		
		sStruct[sPtr] = val;
		sPtr++;
	}
	
	public Object pop() throws StackUnderflowError {
		if( sPtr == 0 ) throw new StackUnderflowError("Stack is empty");
		Object r = sStruct[sPtr-1];
		
		sStruct[sPtr-1] = null;
		sPtr--;
		
		return r;
	}
	
	public Object top() { return sStruct[sPtr-1]; }
	
	public boolean isEmpty() { return sPtr == 0; }
	public boolean isFull() { return sPtr == MAX; }
	public int size() { return sPtr; }
}
