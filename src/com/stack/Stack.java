package com.stack;

import com.utils.StackUnderflowError;
import com.utils.UnexpectedValueException;

public class Stack {
	private Object[] sStruct = null;
	private int MAX = -1;
	private int sPtr = 0;
	private int expR = 2;
	private boolean isDynamic = false;
	
	
	// CONSTRUCTORS
	
	public Stack() {
	   isDynamic = true;
	   MAX = 4;
	   inflate();
	}
	
	public Stack( int maxSize ) throws UnexpectedValueException{
	   if( maxSize <= 0 ) {
	      throw new UnexpectedValueException( "maxSize cannot be <= to 0!" );
	   }
		sStruct = new Object[maxSize];
		MAX = maxSize;		
	}
	
	// OPERATORS
	
	public Stack push( Object val ) throws StackOverflowError{
	   if( isDynamic && isFull() ) expand();
	   else if( isFull() ) throw new StackOverflowError("Stack is full");
		
		sStruct[sPtr] = val;
		sPtr++;
		
		return this; // Chainable
	}
	
	public Object pop() throws StackUnderflowError {
		if( sPtr == 0 ) throw new StackUnderflowError("Stack is empty");
		Object r = sStruct[sPtr-1];
		
		sStruct[sPtr-1] = null;
		sPtr--;
		
		return r;
	}
	
	public Object top() { return sStruct[sPtr-1]; }
	
	//EXTRA
	
	public boolean isEmpty() { return sPtr == 0; }
	public boolean isFull() { return sPtr == MAX; }
	public int size() { return sPtr; }
	public void setExpRate( int newVal ) { expR = newVal; } // Set dynamic expansion rate
	public boolean isDynamic() { return isDynamic; }
	
	public void deflate() throws UnexpectedValueException {
	   int newSize = 0;
	   for (int i = 0; i < sStruct.length; i++) {
	      if( sStruct[i] != null ) newSize++;
      }
	   
	   if( newSize > MAX || newSize == 0 ) throw new UnexpectedValueException(" newSize is " + newSize);
	   MAX = newSize;
	   inflate();
	}
	
	private void inflate() {
	   Object[] temp = new Object[ MAX ];
	         
	   if( sStruct != null ) { 
	      int i = 0;
	      for( Object o : sStruct ) {
	         temp[i] = o;
	         i++;
	      }
	   }
      
      sStruct = temp;
	}
	
	private void expand() {
      MAX *= expR;
      inflate();
   }
	
	//	UTILS
	
	@Override
	public String toString() {
		String r = this.getClass().getSimpleName() + " = [  ";
		
		for (int i = 0; i != sStruct.length; i++) {
			r += i + ":[ " + sStruct[i] + " ]";
			if(!( i + 1  == sStruct.length )) {
				r += ",  ";
			}
		}
		
		r += "  ];";
		
		return r;
	}
	
	public Object[] toArray() {
		return sStruct;
	}
}
