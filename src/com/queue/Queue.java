package com.queue;

import com.utils.StackUnderflowError;

public class Queue {
	private Object[] qStruct = null;
	private int MAX = 0;
	private int back = 0;
	
	public Queue( int max ) {
		MAX = max;
		qStruct = new Object[MAX];
	}
	
	public void enqueue( Object v ) {
		if( isFull() ) throw new StackOverflowError("Queue is full");
		qStruct[back] = v;
		back++;
	}
	
	public Object dequeue() {
		if( back == 0 ) throw new StackUnderflowError("Queue is empty");
		Object ret = qStruct[0];
		shiftElements();
		back--;
		return ret;
	}
	
	public Object front() {
		if( back == 0 ) throw new StackUnderflowError("Queue is empty");
		return qStruct[0];
	}
	
	private void shiftElements() {
		if( back == 1 ) return;
		for (int i = 1; i != back ; i++) {
			qStruct[i-1] = qStruct[i];
		}
	}	
	
	public boolean isFull() { return back-1 == MAX; }
	public boolean isEmpty() { return back == 0; }
	
	
	
	@Override
	public String toString() {
		String r = this.getClass().getSimpleName() + " = [  ";
		
		for (int i = 0; i != back ; i++) {
			r += i + ":[ " + qStruct[i] + " ]";
			if(!( i + 1  == back )) {
				r += ",  ";
			}
		}
		
		r += "  ];";
		
		return r;
	}	
	
	// WRAPPERS
	public Object deQ() { return  dequeue();    }
	public void enQ( Object o ) { enqueue( o ); }

}
